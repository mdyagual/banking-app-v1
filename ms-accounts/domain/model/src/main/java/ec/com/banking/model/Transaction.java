package ec.com.banking.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Long transactionId;
    private LocalDate transactionDate;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal initialBalance;
    private BigDecimal availableBalance;
    private Long accountId;


    public Transaction(Long transactionId, LocalDate transactionDate, String transactionType, BigDecimal amount, BigDecimal initialBalance, BigDecimal availableBalance, Long accountId) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.availableBalance = availableBalance;
        this.accountId = accountId;
    }


    public static Transaction opened(String transactionType, BigDecimal amount, Long accountId) {
        return new Transaction(null, LocalDate.now(), transactionType, amount, null, null, accountId);
    }

    public static Transaction closed(String transactionType, BigDecimal amount, BigDecimal initialBalance, BigDecimal availableBalance, Long accountId) {
        return new Transaction(null, LocalDate.now(), transactionType, amount, initialBalance, availableBalance, accountId);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
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
