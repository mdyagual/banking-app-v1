package ec.com.banking.usecase.account;

import ec.com.banking.core.exception.AccountDuplicatedException;
import ec.com.banking.core.gateway.AccountRepository;
import ec.com.banking.core.gateway.BusMessageBroker;
import ec.com.banking.model.Account;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;
    private final BusMessageBroker busMessageBroker;

    public SaveAccountUseCase(AccountRepository accountRepository, BusMessageBroker busMessageBroker) {
        this.accountRepository = accountRepository;
        this.busMessageBroker = busMessageBroker;
    }

    public Account execute(Account account) {
        if(accountRepository.existsByAccountNumber(account.getAccountNumber())){
            throw new AccountDuplicatedException(account.getAccountNumber());
        }
        if(busMessageBroker.validateClient(account.getClientId()).containsValue(false)){
            throw new IllegalArgumentException("Client with ID " + account.getClientId() + " does not exist.");
        }

        return accountRepository.save(account);
    }
}
