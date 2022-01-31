package domain;

import domain.evaluation.ExpressionEvaluator;
import domain.expression.Expression;
import domain.expression.ExpressionFactory;
import domain.parsing.ExpressionParser;
import domain.parsing.ParseResult;

public class DomainFacade {
    public ParseResult parse(String input) {
        return new ExpressionParser(factory()).parse(input);
    }

    public int evaluate(Expression expr) {
        return new ExpressionEvaluator().evaluate(expr);
    }

    public ExpressionFactory factory() {
        return new ExpressionFactory();
    }
}
