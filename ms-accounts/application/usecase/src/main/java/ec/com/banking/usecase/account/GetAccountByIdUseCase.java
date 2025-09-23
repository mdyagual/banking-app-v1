package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountNotFoundException;
import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

public class GetAccountByIdUseCase {
    private final AccountRepository  accountRepository;

    public GetAccountByIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Long accountId) {
        if(accountRepository.findById(accountId) == null){
            throw new AccountNotFoundException(accountId);
        }
        return accountRepository.findById(accountId);
    }
}
