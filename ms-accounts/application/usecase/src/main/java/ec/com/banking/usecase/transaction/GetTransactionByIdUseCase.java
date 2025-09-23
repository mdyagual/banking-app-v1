package ec.com.banking.usecase.transaction;

import ec.com.banking.core.exception.TransactionNotFoundException;
import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;

public class GetTransactionByIdUseCase {
    private final TransactionRepository transactionRepository;

    public GetTransactionByIdUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Long id) {
        if(transactionRepository.findById(id) == null) {
            throw new TransactionNotFoundException(id);
        }
        return transactionRepository.findById(id);
    }
}
