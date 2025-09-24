package ec.com.banking.web.handler;

import ec.com.banking.model.Transaction;
import ec.com.banking.usecase.transaction.GetAllTransactionsUseCase;
import ec.com.banking.usecase.transaction.GetTransactionByIdUseCase;
import ec.com.banking.usecase.transaction.SaveTransactionUseCase;
import ec.com.banking.web.dto.request.CreateTransactionDTO;
import ec.com.banking.web.dto.response.TransactionDTO;
import ec.com.banking.web.mapper.ITransactionMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionHandler {
    private final GetAllTransactionsUseCase getAllTransactionsUseCase;
    private final GetTransactionByIdUseCase getTransactionByIdUseCase;
    private final SaveTransactionUseCase saveTransactionUseCase;


    private final ITransactionMapper mapper;

    public TransactionHandler(GetAllTransactionsUseCase getAllTransactionsUseCase,
                              GetTransactionByIdUseCase getTransactionByIdUseCase,
                              SaveTransactionUseCase saveTransactionUseCase,
                              ITransactionMapper mapper) {
        this.getAllTransactionsUseCase = getAllTransactionsUseCase;
        this.getTransactionByIdUseCase = getTransactionByIdUseCase;
        this.saveTransactionUseCase = saveTransactionUseCase;
        this.mapper = mapper;
    }

    public List<TransactionDTO> findAll() {
        return getAllTransactionsUseCase.execute().stream().map(mapper::toDTO).toList();
    }

    public TransactionDTO findById(Long id) {
        return mapper.toDTO(getTransactionByIdUseCase.execute(id));
    }

    public TransactionDTO save(CreateTransactionDTO transactionDTO) {
        return mapper.toDTO(saveTransactionUseCase.execute(Transaction.opened(
                transactionDTO.getTransactionType(),
                transactionDTO.getAmount(),
                transactionDTO.getAccountId()
        )));
    }


}
