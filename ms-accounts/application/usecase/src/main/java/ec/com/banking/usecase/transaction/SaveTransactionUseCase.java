package ec.com.banking.usecase.transaction;

import ec.com.banking.core.exception.TransactionNotValidException;
import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;

public class SaveTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public SaveTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Transaction transaction) {
        if(transaction.getAmount().compareTo(transaction.getAvailableBalance()) > 0){
            throw new TransactionNotValidException(transaction.getAccountId());
        }
        return transactionRepository.save(transaction);
    }
}
