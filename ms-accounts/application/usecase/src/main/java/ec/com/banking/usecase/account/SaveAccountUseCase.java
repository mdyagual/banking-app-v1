package ec.com.banking.usecase.account;

import ec.com.banking.core.gateway.AccountRepository;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;

    public SaveAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(ec.com.banking.model.Account account) {
        accountRepository.save(account);
    }
}
