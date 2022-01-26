import adapter.Server;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import port.QueryProcessor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;

public class ServerTest {
    private QueryProcessor queryProcessor;

    @Before
    public void setUp() {
        queryProcessor = mock(QueryProcessor.class);
    }

    @Test
    public void oneParseRequestSent() {
        Server server = new Server(streamFromString("oneline\n"), queryProcessor);
        server.start();
        verify(queryProcessor, times(1)).processQuery("oneline");
        verify(queryProcessor, atMostOnce()).processQuery(any());
        verifyNoMoreInteractions(queryProcessor);
    }

    @Test
    public void twoParseRequestsSentInOrder() {
        Server server = new Server(streamFromString("oneline\nsecondLine\n"), queryProcessor);
        server.start();
        InOrder inOrder = inOrder(queryProcessor, queryProcessor);
        inOrder.verify(queryProcessor, times(1))
                .processQuery("oneline");
        inOrder.verify(queryProcessor, times(1))
                .processQuery("secondLine");
        verify(queryProcessor, atMost(2)).processQuery(any());
        verifyNoMoreInteractions(queryProcessor);
    }

    private InputStream streamFromString(String string) {
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }
}
