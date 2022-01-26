package adapter;

import application.App;

import java.io.InputStream;
import java.util.Scanner;

public class Server {
    private final App app;
    private InputStream inputStream;

    public Server(InputStream inputStream, App app) {
        this.app = app;
        this.inputStream = inputStream;
    }

     public void start() {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            app.processQuery(input);
        }
    }
}