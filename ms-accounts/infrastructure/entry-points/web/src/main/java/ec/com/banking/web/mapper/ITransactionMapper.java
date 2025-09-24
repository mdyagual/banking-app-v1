package ec.com.banking.web.mapper;

import ec.com.banking.model.Transaction;
import ec.com.banking.web.dto.response.TransactionDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", implementationName = "WebTransactionMapperImpl")
public interface ITransactionMapper {
    TransactionDTO toDTO(Transaction transaction);

}
