package main;

import adapter.Reporter;
import adapter.Server;
import application.App;

public class Main {

    public static void main(String[] args) {
        Reporter reporter = new Reporter(System.out);
        App app = new App(reporter);
        Server server = new Server(System.in, app);
        server.start();
    }

}
