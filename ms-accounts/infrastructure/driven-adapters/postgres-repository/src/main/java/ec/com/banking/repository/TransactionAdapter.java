package ec.com.banking.repository;

import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;
import ec.com.banking.repository.config.ITransactionRepository;
import ec.com.banking.repository.mapper.ITransactionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionAdapter implements TransactionRepository {
    private final ITransactionRepository repository;
    private final ITransactionMapper mapper;

    public TransactionAdapter(ITransactionRepository repository, ITransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Transaction> getAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Transaction findById(Long transactionId) {
        return mapper.toModel(repository.findById(transactionId).orElse(null));
    }

    @Override
    public Transaction save(Transaction transaction) {
        return mapper.toModel(repository.save(mapper.toEntity(transaction)));
    }
}
