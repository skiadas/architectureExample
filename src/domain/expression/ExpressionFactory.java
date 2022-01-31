package domain.expression;

public class ExpressionFactory {
    public Expression sum(Expression e1, Expression e2) {
        return new SumExpression(e1, e2);
    }

    public Expression integer(int n) {
        return new IntExpression(n);
    }
}
