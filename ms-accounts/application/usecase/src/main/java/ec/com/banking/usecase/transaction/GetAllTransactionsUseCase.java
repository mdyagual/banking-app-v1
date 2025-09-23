package ec.com.banking.usecase.transaction;

import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;

import java.util.List;

public class GetAllTransactionsUseCase {
    private final TransactionRepository transactionRepository;

    public GetAllTransactionsUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> execute() {
        return transactionRepository.getAll();
    }
}
