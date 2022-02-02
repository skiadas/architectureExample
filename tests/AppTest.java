import application.App;
import domain.parsing.ExpressionParser;
import org.junit.Before;
import org.junit.Test;
import port.ResultHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class AppTest {
    private ResultHandler resultHandler;
    private App app;

    public static void main(String[] args) {
        // Writing our own test suite?
        Method[] methods = AppTest.class.getDeclaredMethods();
        // Find setup method
        Method setupMethod = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                setupMethod = method;
            }
        }
        // Now we run each test
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                // Each test needs its own object
                AppTest testObject = new AppTest();
                try {
                    if (setupMethod != null) {
                        setupMethod.invoke(testObject);
                    }
                    method.invoke(testObject);
                    System.out.println("TEST OK! " + method.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    System.out.println("TEST FAILED! " + method.getName());
                }
            }
        }
    }

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
