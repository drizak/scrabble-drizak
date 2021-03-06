package cl.uchile.dcc.scrabble.exceptions;

/** Thrown when two operands in an AST cannot be evaluated with a certain operation. */
public class ASTOperationException extends ScrabbleException {
    public ASTOperationException(String msg){
        super(msg);
    }
}
