package ec.com.banking.core.exception;

public class AccountNotFoundException extends RuntimeException {
    private final Long accountId;
    public AccountNotFoundException(Long accountId) {
        super(String.format("Account with ID %d not found", accountId));
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
