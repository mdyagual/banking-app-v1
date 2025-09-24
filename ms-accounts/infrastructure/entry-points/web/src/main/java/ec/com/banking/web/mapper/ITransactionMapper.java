package ec.com.banking.web.mapper;

import ec.com.banking.model.Transaction;
import ec.com.banking.web.dto.request.CreateTransactionDTO;
import ec.com.banking.web.dto.response.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "WebTransactionMapperImpl")
public interface ITransactionMapper {
    @Mapping(target="transactionId", ignore = true)
    @Mapping(target="transactionDate", ignore = true)
    @Mapping(target="initialBalance", ignore = true)
    @Mapping(target="availableBalance", ignore = true)
    Transaction toDomain(CreateTransactionDTO transactionDTO);



    TransactionDTO toDTO(Transaction transaction);

}
