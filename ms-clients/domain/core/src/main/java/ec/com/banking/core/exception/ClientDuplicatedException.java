package ec.com.banking.core.exception;

public class ClientDuplicatedException extends RuntimeException {
    private final String idNumber;

    public ClientDuplicatedException(String idNumber) {
        super(String.format("Client with idNumber: %s, already exists", idNumber));

        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }
}
