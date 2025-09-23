package ec.com.banking.usecase.account;

import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;

    public UpdateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(ec.com.banking.model.Account account) {
        return accountRepository.update(account);
    }
}
