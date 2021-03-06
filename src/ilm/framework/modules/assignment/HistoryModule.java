package ilm.framework.modules.assignment;

import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import ilm.framework.IlmProtocol;
import ilm.framework.assignment.model.AssignmentState;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainConverter;
import ilm.framework.domain.DomainModel;
import ilm.framework.modules.AssignmentModule;
import ilm.framework.modules.IlmModule;

public class HistoryModule extends AssignmentModule {

	private Vector _history;

	public HistoryModule() {
		_history = new Vector();
		_name = IlmProtocol.HISTORY_MODULE_NAME;
		_gui = new HistoryModuleToolbar();
		_observerType = ACTION_OBSERVER;
	}

	Vector getHistory() {
		return (Vector) _history.get(_assignmentIndex);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof DomainAction) {
			DomainAction action = (DomainAction) o;
			if (!action.isUndo()) {
				((Vector) _history.get(_assignmentIndex))
						.add((DomainAction) action.clone());
				setChanged();
				notifyObservers();
			} else {
				((Vector) _history.get(_assignmentIndex))
						.remove(((Vector) _history.get(_assignmentIndex))
								.size() - 1);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void setContentFromString(DomainConverter converter, int index,
			String moduleContent) {
		if (_history.size() == index) {
			addAssignment();
		}
		Vector actionArray = converter.convertStringToAction(moduleContent);
		for (int i = 0; i < actionArray.size(); i++) {
			((DomainAction) actionArray.get(i)).addObserver(this);
			((Vector) _history.get(index)).add(actionArray.get(i));
		}
	}

	public void addAssignment() {
		_history.add(new Vector());
	}

	public void print() {
		System.out.println("Name: " + _name + " size: " + _history.size());
		for (int i = 0; i < _history.size(); i++) {
			System.out.println("size: " + ((Vector) _history.get(i)).size());
			for (int j = 0; j < ((Vector) _history.get(i)).size(); j++) {
				DomainAction a = (DomainAction) ((Vector) _history.get(i))
						.get(j);
				System.out.println(a.getName() + " " + a.getDescription());
			}
		}
	}

	public String getStringContent(DomainConverter converter, int index) {
		if (((Vector) _history.get(_assignmentIndex)).size() == 0) {
			return "<" + _name + "/>";
		}
		String string = "<" + _name + ">";
		string += converter.convertActionToString((Vector) _history.get(index));
		string += "</" + _name + ">";
		return string;
	}

	public void removeAssignment(int index) {
		_history.remove(index);
	}

	public void setDomainModel(DomainModel model) {
		for (int i = 0; i < _history.size(); i++) {
			Vector list = (Vector) _history.get(i);
			for (int j = 0; j < list.size(); j++) {
				DomainAction action = (DomainAction) list.get(j);
				action.setDomainModel(model);
			}
		}
	}

	public void setState(AssignmentState state) {
		for (int i = 0; i < ((Vector) _history.get(_history.size() - 1)).size(); i++) {
			DomainAction action = (DomainAction) ((Vector) _history
					.get(_history.size() - 1)).get(i);
			action.setState(state);
		}
	}

	public void setActionObservers(Collection values) {
		Iterator valuesIterator = values.iterator();
		while (valuesIterator.hasNext()) {
			IlmModule m = (IlmModule) valuesIterator.next();
			if (m instanceof AssignmentModule) {
				for (int i = 0; i < _history.size(); i++) {
					Vector list = (Vector) _history.get(i);
					for (int j = 0; j < list.size(); j++) {
						DomainAction action = (DomainAction) list.get(j);
						action.addObserver((AssignmentModule) m);
					}
				}
			}
		}
	}
}
