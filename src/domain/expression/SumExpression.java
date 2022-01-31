package domain.expression;

public class SumExpression implements Expression {
    public final Expression e1;
    public final Expression e2;

    SumExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

}
