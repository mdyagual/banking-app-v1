package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountDuplicatedException;
import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;

    public SaveAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        if(accountRepository.existsByAccountNumber(account.getAccountNumber())){
            throw new AccountDuplicatedException(account.getAccountNumber());
        }
        return accountRepository.save(account);
    }
}
