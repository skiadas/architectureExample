package port;

public interface ResultHandler {
    void reportError(String errorMessage);
    void reportResult(int result);
}
