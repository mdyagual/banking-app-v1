package ec.com.banking.usecase.transaction;

import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;

public class SaveTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public SaveTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
