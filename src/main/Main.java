package main;

import adapter.Reporter;
import port.ResultHandler;
import adapter.Server;
import application.App;
import port.QueryProcessor;

public class Main {

    public static void main(String[] args) {
        ResultHandler reporter = new Reporter(System.out);
        QueryProcessor app = new App(reporter);
        Server server = new Server(System.in, app);
        server.start();
    }

}
