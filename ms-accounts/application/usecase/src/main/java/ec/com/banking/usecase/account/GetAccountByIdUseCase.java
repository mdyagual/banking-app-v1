package ec.com.banking.usecase.account;

import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.model.Account;

public class GetAccountByIdUseCase {
    private final AccountRepository  accountRepository;

    public GetAccountByIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Long id) {
        return accountRepository.findById(id);
    }
}
