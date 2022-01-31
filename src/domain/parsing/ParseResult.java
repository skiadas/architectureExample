package domain.parsing;

import domain.expression.Expression;

public abstract class ParseResult {
    static ParseResult success(Expression expr) {
        return new SuccessfulParseResult(expr);
    }

    static ParseResult error(String errorMessage) {
        return new ErrorParseResult(errorMessage);
    }

    public abstract void handle(SuccessHandler onSuccess, ErrorHandler onError);

    private static class SuccessfulParseResult extends ParseResult {
        public final Expression expr;

        private SuccessfulParseResult(Expression expr) {
            this.expr = expr;
        }

        public void handle(SuccessHandler onSuccess, ErrorHandler onError) {
            onSuccess.handleSuccess(expr);
        }
    }

    private static class ErrorParseResult extends ParseResult {
        public final String errorMessage;

        private ErrorParseResult(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public void handle(SuccessHandler onSuccess, ErrorHandler onError) {
            onError.handleError(errorMessage);
        }
    }

    @FunctionalInterface
    public interface ErrorHandler {
        void handleError(String errorMessage);
    }

    @FunctionalInterface
    public interface SuccessHandler {
        void handleSuccess(Expression expr);
    }
}
