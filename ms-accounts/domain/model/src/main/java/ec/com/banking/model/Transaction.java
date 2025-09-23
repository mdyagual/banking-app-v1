package ec.com.banking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long transactionId;
    private LocalDateTime transactionDate;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal initialBalance;
    private BigDecimal availableBalance;
    private Long accountId;

    public Transaction(Long transactionId, LocalDateTime transactionDate, String transactionType, BigDecimal amount, BigDecimal initialBalance, BigDecimal availableBalance, Long accountId) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.availableBalance = availableBalance;
        this.accountId = accountId;
    }

    public static Transaction newTransaction(String transactionType, BigDecimal amount, BigDecimal initialBalance, BigDecimal availableBalance, Long accountId) {
        return new Transaction(null, LocalDateTime.now(), transactionType, amount, initialBalance, availableBalance, accountId);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
