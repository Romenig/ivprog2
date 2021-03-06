package usp.ime.line.ivprog.model.components.datafactory;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Comment;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVectorReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;

public class DataFactory implements IDataFactory {

	/**
	 * This integer grants an unique id for each DomainObject
	 */
	private static int objectID = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createConstant()
	 */
	public DataObject createConstant() {
		Variable variable = new Variable("constant", "constant");
		variable.setUniqueID(objectID++);
		return variable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createVariable()
	 */
	public DataObject createVariable() {
		Variable variable = new Variable("variable", "variable");
		variable.setUniqueID(objectID++);
		return variable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createIVPArray()
	 */
	public DataObject createIVPVector() {
		IVPVector array = new IVPVector("array", "array");
		array.setUniqueID(objectID++);
		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createMatrix()
	 */
	public DataObject createIVPMatrix() {
		IVPMatrix matrix = new IVPMatrix("matrix", "matrix");
		matrix.setUniqueID(objectID++);
		return matrix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createOperation()
	 */
	public DataObject createOperation() {
		Operation op = new Operation("operation", "operation");
		op.setUniqueID(objectID++);
		return op;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createIfElse()
	 */
	public DataObject createIfElse() {
		IfElse ifelse = new IfElse("ifelse", "ifelse");
		ifelse.setUniqueID(objectID++);
		return ifelse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#createFor
	 * ()
	 */
	public DataObject createFor() {
		For f = new For("for", "for");
		f.setUniqueID(objectID++);
		return f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createWhile()
	 */
	public DataObject createWhile() {
		While w = new While("while", "while");
		w.setUniqueID(objectID++);
		return w;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createPrint()
	 */
	public DataObject createPrint() {
		Print print = new Print("print", "print");
		print.setUniqueID(objectID++);
		return print;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createComment()
	 */
	public DataObject createComment() {
		Comment comment = new Comment("comment", "comment");
		comment.setUniqueID(objectID++);
		return comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createAttributionLine()
	 */
	public DataObject createAttributionLine() {
		AttributionLine attline = new AttributionLine("attributionline",
				"attributionline");
		attline.setUniqueID(objectID++);
		return attline;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createReturnStatement()
	 */
	public DataObject createReturnStatement() {
		ReturnStatement returnStatement = new ReturnStatement(
				"returnstatement", "returnstatement");
		returnStatement.setUniqueID(objectID++);
		return returnStatement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createFunction()
	 */
	public DataObject createFunction() {
		Function f = new Function("function", "function");
		f.setUniqueID(objectID++);
		return f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createFunctionReference()
	 */
	public DataObject createFunctionReference() {
		FunctionReference fr = new FunctionReference("functionreference",
				"functionreference");
		fr.setUniqueID(objectID++);
		return fr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createVarReference()
	 */
	public DataObject createVarReference() {
		VariableReference varRef = new VariableReference("variablereference",
				"variablereference");
		varRef.setUniqueID(objectID++);
		return varRef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createIVPVectorReference()
	 */
	public DataObject createIVPVectorReference() {
		IVPVectorReference vRef = new IVPVectorReference("vectorreference",
				"vectorreference");
		vRef.setUniqueID(objectID++);
		return vRef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createIVPMatrixReference()
	 */
	public DataObject createIVPMatrixReference() {
		IVPMatrixReference mRef = new IVPMatrixReference("matrixreference",
				"matrixreference");
		mRef.setUniqueID(objectID++);
		return mRef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see usp.ime.line.ivprog.components.databuilder.dataobjetcs.IDataFactory#
	 * createAskUser()
	 */
	public DataObject createAskUser() {
		AskUser ask = new AskUser("askuser", "askuser");
		ask.setUniqueID(objectID++);
		return ask;
	}
}
