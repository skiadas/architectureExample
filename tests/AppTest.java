import application.App;
import domain.parsing.ExpressionParser;
import org.junit.Before;
import org.junit.Test;
import port.ResultHandler;

import static org.mockito.Mockito.*;

public class AppTest {
    private ResultHandler resultHandler;
    private App app;

    @Before
    public void setUp() {
        resultHandler = mock(ResultHandler.class);
        app = new App(resultHandler);
    }

    @Test
    public void testAdditionNoSpaces() {
        app.processQuery("23+34");
        verify(resultHandler).reportResult(23 + 34);
        verify(resultHandler, never()).reportError(any());
    }

    @Test
    public void testAdditionWithSpaces() {
        app.processQuery("25 + 36");
        verify(resultHandler).reportResult(25 + 36);
        verify(resultHandler, never()).reportError(any());
    }

    @Test
    public void testAdditionInvalidInput() {
        app.processQuery("23");
        verify(resultHandler).reportError(ExpressionParser.PARSE_ERROR_MESSAGE);
        verify(resultHandler, never()).reportResult(anyInt());
    }
}
