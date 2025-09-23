package ec.com.banking.core.gateway;

import ec.com.banking.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> getAll();
    Transaction findById(Long transactionId);
    Transaction save(Transaction transaction);
}
