package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountNotFoundException;
import ec.com.banking.core.gateway.AccountRepository;

public class DeleteAccountUseCase {
    private final AccountRepository accountRepository;

    public DeleteAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Long id) {
        if(accountRepository.findById(id) == null) {
            throw new AccountNotFoundException(id);
        }
        accountRepository.delete(id);
    }
}
