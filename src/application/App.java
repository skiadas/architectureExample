package application;

import port.ResultHandler;
import port.QueryProcessor;

public class App implements QueryProcessor {
    public static final String PARSE_ERROR_MESSAGE = "Cannot parse expression";
    private final ResultHandler resultHandler;

    public App(ResultHandler resultHandler) {
        this.resultHandler = resultHandler;
    }

    public void processQuery(String input) {
        String[] parts = input.split("\\+");
        if (parts.length != 2) {
            resultHandler.reportError(PARSE_ERROR_MESSAGE);
        } else {
            int a = Integer.parseInt(parts[0].trim());
            int b = Integer.parseInt(parts[1].trim());
            int result = a + b;
            resultHandler.reportResult(result);
        }
    }
}