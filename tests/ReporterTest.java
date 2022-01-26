import adapter.Reporter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ReporterTest {

    private ByteArrayOutputStream outStream;
    private Reporter reporter;

    @Before
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        reporter = new Reporter(new PrintStream(outStream));
    }

    @Test
    public void testErrorMessageReported() {
        String errorMessage = "Hi there!";
        reporter.reportError(errorMessage);
        assertEquals(errorMessage + "\n", getOutput());
    }

    @Test
    public void testNormalMessageReported() {
        int anInt = 36;
        reporter.reportResult(anInt);
        assertEquals(anInt + "\n", getOutput());
    }

    private String getOutput() {
        return outStream.toString(StandardCharsets.UTF_8);
    }
}
