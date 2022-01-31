package application;

import domain.DomainFacade;
import domain.expression.Expression;
import domain.parsing.ParseResult;
import port.QueryProcessor;
import port.ResultHandler;

public class App implements QueryProcessor {
    private final ResultHandler resultHandler;
    private final DomainFacade domain = new DomainFacade();

    public App(ResultHandler resultHandler) {
        this.resultHandler = resultHandler;
    }

    public void processQuery(String input) {
        ParseResult parseResult = domain.parse(input);
        parseResult.handle(
                (Expression expr) -> resultHandler.reportResult(domain.evaluate(expr)),
                (String error) -> resultHandler.reportError(error));
    }
}