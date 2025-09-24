package ec.com.banking.core.gateway;

import ec.com.banking.model.StatementReport;
import ec.com.banking.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository {
    List<Transaction> getAll();
    Transaction findById(Long transactionId);
    Transaction save(Transaction transaction);
    List<Transaction> getForStatementReport(LocalDateTime startDate, LocalDateTime endDate);
}
