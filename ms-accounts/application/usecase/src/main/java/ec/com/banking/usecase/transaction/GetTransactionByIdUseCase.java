package ec.com.banking.usecase.transaction;

import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;

public class GetTransactionByIdUseCase {
    private final TransactionRepository transactionRepository;

    public GetTransactionByIdUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Long id) {
        return transactionRepository.findById(id);
    }
}
