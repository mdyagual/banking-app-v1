package ec.com.banking.repository.mapper;

import ec.com.banking.model.Transaction;
import ec.com.banking.repository.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "RepositoryTransactionMapperImpl")
public interface ITransactionMapper {

    @Mapping(target = "accountId", source = "account.accountId")
    Transaction toModel(TransactionEntity transactionEntity);

    @Mapping(target = "account", ignore = true)
    TransactionEntity toEntity(Transaction transaction);





}
