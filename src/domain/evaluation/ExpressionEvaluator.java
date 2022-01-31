package domain.evaluation;

import domain.expression.Expression;
import domain.expression.IntExpression;
import domain.expression.SumExpression;

public class ExpressionEvaluator {
    public int evaluate(Expression expr) {
        if (expr instanceof SumExpression) {
            return evaluateSum((SumExpression) expr);
        } else if (expr instanceof IntExpression) {
            return evaluateInt((IntExpression) expr);
        } else {
            throw new RuntimeException("Unimplemented evaluation for expression");
        }
    }

    private int evaluateInt(IntExpression expr) {
        return expr.n;
    }

    private int evaluateSum(SumExpression expr) {
        return evaluate(expr.e1) + evaluate(expr.e2);
    }
}
