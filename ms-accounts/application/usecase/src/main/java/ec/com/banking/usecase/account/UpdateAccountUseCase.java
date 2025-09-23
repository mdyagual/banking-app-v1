package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountNotFoundException;
import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;

    public UpdateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        if(accountRepository.findById(account.getAccountId()) == null){
            throw new AccountNotFoundException(account.getAccountId());
        }
        return accountRepository.update(account);
    }
}
