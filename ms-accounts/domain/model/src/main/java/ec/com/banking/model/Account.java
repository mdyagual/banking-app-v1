package ec.com.banking.model;

import java.math.BigDecimal;
import java.util.List;

public class Account {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private BigDecimal onlineBalance;
    private Boolean status;
    private Long customerId;
    private List<Transaction> transactions;

    public Account(Long accountId, String accountNumber, String accountType, BigDecimal onlineBalance, Boolean status, Long customerId, List<Transaction> transactions) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.onlineBalance = onlineBalance;
        this.status = status;
        this.customerId = customerId;
        this.transactions = transactions;
    }

    public static Account newAccount(String accountNumber, String accountType, BigDecimal onlineBalance, Long customerId) {
        return new Account(null, accountNumber, accountType, onlineBalance, true, customerId, null);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public BigDecimal getOnlineBalance() {
        return onlineBalance;
    }

    public void setOnlineBalance(BigDecimal onlineBalance) {
        this.onlineBalance = onlineBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
