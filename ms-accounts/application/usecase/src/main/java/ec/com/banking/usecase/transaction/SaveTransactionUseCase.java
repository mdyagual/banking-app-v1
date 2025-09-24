package ec.com.banking.usecase.transaction;

import ec.com.banking.core.exception.AccountNotFoundException;
import ec.com.banking.core.exception.TransactionNotValidException;
import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Account;
import ec.com.banking.model.Transaction;
import ec.com.banking.usecase.account.GetAccountByIdUseCase;
import ec.com.banking.usecase.account.UpdateAccountUseCase;

public class SaveTransactionUseCase {
    private final TransactionRepository transactionRepository;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    public SaveTransactionUseCase(TransactionRepository transactionRepository,
                                  GetAccountByIdUseCase getAccountByIdUseCase,
                                  UpdateAccountUseCase updateAccountUseCase) {
        this.transactionRepository = transactionRepository;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
    }

    public Transaction execute(Transaction transaction) {
        Account accountCheck = getAccountByIdUseCase.execute(transaction.getAccountId());
        if(accountCheck == null) {
            throw new AccountNotFoundException(transaction.getAccountId());
        }
        if(transaction.getAmount().compareTo(accountCheck.getOnlineBalance()) > 0){
            throw new TransactionNotValidException(transaction.getAccountId());
        }

        Account account = updateAccountUseCase.execute(Account.updateAccount(
                accountCheck.getAccountId(),
                accountCheck.getAccountNumber(),
                accountCheck.getAccountType(),
                transaction.getTransactionType().equals("D") ? accountCheck.getOnlineBalance().subtract(transaction.getAmount()) : accountCheck.getOnlineBalance().add(transaction.getAmount()),
                accountCheck.getClientId(),
                accountCheck.getTransactions()
        ));

        return transactionRepository.save(
                Transaction.closed(
                        transaction.getTransactionType(),
                        transaction.getAmount(),
                        accountCheck.getOnlineBalance(),
                        account.getOnlineBalance(),
                        account.getAccountId())
                );
    }
}
