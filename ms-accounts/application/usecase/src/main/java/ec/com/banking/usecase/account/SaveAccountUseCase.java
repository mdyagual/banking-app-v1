package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountDuplicatedException;
import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.core.gateway.CheckClientMessage;
import ec.com.banking.model.Account;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;
    private final CheckClientMessage checkClientMessage;

    public SaveAccountUseCase(AccountRepository accountRepository, CheckClientMessage checkClientMessage) {
        this.accountRepository = accountRepository;
        this.checkClientMessage = checkClientMessage;
    }

    public Account execute(Account account) {
        if(accountRepository.existsByAccountNumber(account.getAccountNumber())){
            throw new AccountDuplicatedException(account.getAccountNumber());
        }
        if(!(boolean) checkClientMessage.obtain(account.getClientId()).get("exists")){
            throw new IllegalArgumentException("Client with ID " + account.getClientId() + " does not exist.");
        }

        return accountRepository.save(account);
    }
}
