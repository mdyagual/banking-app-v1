package ec.com.banking.core.exception;

public class TransactionNotFoundException extends RuntimeException {
    private final Long transactionId;
    public TransactionNotFoundException(Long transactionId) {
        super(String.format("Transaction with ID %d not found", transactionId));
        this.transactionId = transactionId;

    }
    public Long getTransactionId() {
        return transactionId;
    }
}
