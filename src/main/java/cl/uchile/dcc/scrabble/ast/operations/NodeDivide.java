package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Division operation inside an AST. */
public class NodeDivide extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the Divide Node
     * @param nodeL First Division operand
     * @param nodeR Second Division operand
     */
    public NodeDivide(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        try {
            IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
            IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
            return (ISType) resultL.divide(resultR);
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to an IArithmeticOperable");
        }
    }
}
