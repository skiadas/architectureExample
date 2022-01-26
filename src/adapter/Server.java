package adapter;

import port.QueryProcessor;

import java.io.InputStream;
import java.util.Scanner;

public class Server {
    private final QueryProcessor queryProcessor;
    private final InputStream inputStream;

    public Server(InputStream inputStream, QueryProcessor queryProcessor) {
        this.queryProcessor = queryProcessor;
        this.inputStream = inputStream;
    }

     public void start() {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            queryProcessor.processQuery(input);
        }
    }
}