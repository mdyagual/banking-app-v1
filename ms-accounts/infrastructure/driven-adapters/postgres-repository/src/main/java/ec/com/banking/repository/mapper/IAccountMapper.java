package ec.com.banking.repository.mapper;

import ec.com.banking.model.Account;
import ec.com.banking.repository.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationName = "RepositoryAccountMapperImpl")
public interface IAccountMapper {

    @Mapping(
            target = "transactions",
            expression = "java(accountEntity.getTransactions() == null ? java.util.Collections.emptyList() : accountEntity.getTransactions().stream().map(t -> t.getTransactionId()).toList())"
    )
    Account toModel(AccountEntity accountEntity);

    @Mapping(target = "transactions", ignore = true)
    AccountEntity toEntity(Account account);


}
