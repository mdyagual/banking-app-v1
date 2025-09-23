package ec.com.banking.core.exception;

public class AccountDuplicatedException extends RuntimeException {
    private final String accNumber;

    public AccountDuplicatedException(String accNumber) {
        super(String.format("Account with accNumber: %s, already exists", accNumber));
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }
}
