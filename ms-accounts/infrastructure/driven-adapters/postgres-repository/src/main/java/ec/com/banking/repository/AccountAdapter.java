package ec.com.banking.repository;

import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;
import ec.com.banking.repository.config.IAccountRepository;
import ec.com.banking.repository.mapper.IAccountMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountAdapter implements AccountRepository {
    private final IAccountRepository repository;
    private final IAccountMapper mapper;

    public AccountAdapter(IAccountRepository repository, IAccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Account> getAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Account findById(Long accountId) {
        return mapper.toModel(repository.findById(accountId).orElse(null));
    }

    @Override
    public Account save(Account account) {
        return mapper.toModel(repository.save(mapper.toEntity(account)));
    }

    @Override
    public Account update(Account account) {
        return mapper.toModel(repository.save(mapper.toEntity(account)));
    }

    @Override
    public void delete(Long accountId) {
        repository.deleteById(accountId);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return false;
    }
}
