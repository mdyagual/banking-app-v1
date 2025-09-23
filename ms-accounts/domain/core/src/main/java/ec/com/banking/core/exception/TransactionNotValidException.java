package ec.com.banking.core.exception;

import ec.com.banking.model.Account;

import java.math.BigDecimal;

public class TransactionNotValidException extends RuntimeException {
    private final Long accountId;
    public TransactionNotValidException(Long accountId) {
        super(String.format("Transaction failed: Account with ID %d does not have enough balance to cover the amount sent", accountId));
        this.accountId = accountId;

    }

    public Long getAccountId() {
        return accountId;
    }
}
