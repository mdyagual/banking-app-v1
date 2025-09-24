package ec.com.banking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StatementReport {
    private LocalDateTime transactionDate;
    private String clientName;
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;

    public StatementReport(LocalDateTime transactionDate, String clientName, String accountNumber, String accountType, BigDecimal initialBalance, BigDecimal transactionAmount, BigDecimal availableBalance, String transactionDescription, Boolean accountStatus) {
        this.transactionDate = transactionDate;
        this.clientName = clientName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.transactionAmount = transactionAmount;
        this.availableBalance = availableBalance;
        this.transactionDescription = transactionDescription;
        this.accountStatus = accountStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
