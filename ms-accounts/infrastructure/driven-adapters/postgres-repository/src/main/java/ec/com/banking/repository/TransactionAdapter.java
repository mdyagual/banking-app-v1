package ec.com.banking.repository;

import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Transaction;
import ec.com.banking.repository.config.IAccountRepository;
import ec.com.banking.repository.config.ITransactionRepository;
import ec.com.banking.repository.entity.AccountEntity;
import ec.com.banking.repository.entity.TransactionEntity;
import ec.com.banking.repository.mapper.ITransactionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionAdapter implements TransactionRepository {
    private final ITransactionRepository repository;
    private final IAccountRepository accountRepository;
    private final ITransactionMapper mapper;

    public TransactionAdapter(ITransactionRepository repository, IAccountRepository accountRepository, ITransactionMapper mapper) {
        this.repository = repository;
        this.accountRepository = accountRepository;
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
        AccountEntity accountEntity = accountRepository.findById(transaction.getAccountId()).orElse(null);
        TransactionEntity transactionEntity = mapper.toEntity(transaction);
        transactionEntity.setAccount(accountEntity);
        return mapper.toModel(repository.save(transactionEntity));
    }
}
