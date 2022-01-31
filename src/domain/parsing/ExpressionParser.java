package domain.parsing;

import domain.expression.Expression;
import domain.expression.ExpressionFactory;

public class ExpressionParser {
    public static final String PARSE_ERROR_MESSAGE = "Cannot parse expression";
    private final ExpressionFactory factory;

    public ExpressionParser(ExpressionFactory expressionFactory) {
        factory = expressionFactory;
    }

    public ParseResult parse(String input) {
        String[] parts = input.split("\\+");
        if (parts.length != 2) {
            return ParseResult.error(PARSE_ERROR_MESSAGE);
        } else {
            int a = Integer.parseInt(parts[0].trim());
            int b = Integer.parseInt(parts[1].trim());
            Expression expr = factory.sum(factory.integer(a),
                                          factory.integer(b));
            return ParseResult.success(expr);
        }
    }
}
