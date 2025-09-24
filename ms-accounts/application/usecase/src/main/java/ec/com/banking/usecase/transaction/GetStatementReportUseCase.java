package ec.com.banking.usecase.transaction;

import ec.com.banking.core.gateway.CheckClientMessage;
import ec.com.banking.core.gateway.TransactionRepository;
import ec.com.banking.model.Account;
import ec.com.banking.model.StatementReport;
import ec.com.banking.model.Transaction;
import ec.com.banking.usecase.account.GetAccountByIdUseCase;

import java.time.LocalDateTime;
import java.util.List;

public class GetStatementReportUseCase {
    private final TransactionRepository transactionRepository;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final CheckClientMessage checkClientMessage;

    public GetStatementReportUseCase(TransactionRepository transactionRepository, GetAccountByIdUseCase getAccountByIdUseCase, CheckClientMessage checkClientMessage) {
        this.transactionRepository = transactionRepository;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.checkClientMessage = checkClientMessage;
    }

    public List<StatementReport> execute(LocalDateTime startDate, LocalDateTime endDate){
        List<Transaction> transactions = transactionRepository.getForStatementReport(startDate, endDate);
        return transactions.stream().map(transaction -> {
            Account account = getAccountByIdUseCase.execute(transaction.getAccountId());
            String clientName = (String) checkClientMessage.obtain(account.getClientId()).get("name");

            return new StatementReport(
                    transaction.getTransactionDate(),
                    clientName,
                    account.getAccountNumber(),
                    account.getAccountType(),
                    transaction.getInitialBalance(),
                    transaction.getAmount(),
                    transaction.getAvailableBalance(),
                    transaction.getTransactionType().equals("D") ? "DEBIT" : "CREDIT",
                    account.getStatus()

            );

        }).toList();

    }


}
