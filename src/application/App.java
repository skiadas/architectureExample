package application;

import adapter.Reporter;

public class App {
    private final Reporter reporter;

    public App(Reporter reporter) {
        this.reporter = reporter;
    }

    public void processQuery(String input) {
        String[] parts = input.split("\\+");
        if (parts.length != 2) {
            reporter.reportError("Cannot parse expression");
        } else {
            int a = Integer.parseInt(parts[0].trim());
            int b = Integer.parseInt(parts[1].trim());
            int result = a + b;
            reporter.reportResult(result);
        }
    }
}