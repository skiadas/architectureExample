package adapter;

import java.io.PrintStream;

public class Reporter {
    private PrintStream outputStream;

    public Reporter(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void reportError(String errorMessage) {
        outputStream.println(errorMessage);
    }

    public void reportResult(int result) {
        outputStream.println(result);
    }
}