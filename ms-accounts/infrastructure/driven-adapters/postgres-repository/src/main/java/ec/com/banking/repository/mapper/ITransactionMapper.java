package ec.com.banking.repository.mapper;

import ec.com.banking.model.Transaction;
import ec.com.banking.repository.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "RepositoryTransactionMapperImpl")
public interface ITransactionMapper {
    Transaction toModel(TransactionEntity transactionEntity);
    TransactionEntity toEntity(Transaction transaction);

    void updateModel(@MappingTarget Transaction transaction, TransactionEntity transactionEntity);
}
