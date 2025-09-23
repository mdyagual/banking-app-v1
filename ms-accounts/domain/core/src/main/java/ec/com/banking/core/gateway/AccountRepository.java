package ec.com.banking.core.gateway;

import ec.com.banking.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAll();
    Account findById(Long accountId);
    Account save(Account account);
    Account update(Account account);
    void delete(Long accountId);

    boolean existsByAccountNumber(String accountNumber);

}
