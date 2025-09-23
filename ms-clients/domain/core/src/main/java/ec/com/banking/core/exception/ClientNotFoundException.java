package ec.com.banking.core.exception;

public class ClientNotFoundException extends RuntimeException {
    private final Long clientId;
    public ClientNotFoundException(Long clientId) {
        super(String.format("Client with ID %d not found", clientId));
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
