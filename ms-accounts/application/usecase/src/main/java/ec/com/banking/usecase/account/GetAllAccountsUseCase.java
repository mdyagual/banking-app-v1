package ec.com.banking.usecase.account;

import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

import java.util.List;

public class GetAllAccountsUseCase {
    private final AccountRepository accountRepository;

    public GetAllAccountsUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> execute() {
        return accountRepository.getAll();
    }
}
