package ec.com.banking.repository.mapper;

import ec.com.banking.model.Account;
import ec.com.banking.repository.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "RepositoryAccountMapperImpl")
public interface IAccountMapper {
    Account toModel(AccountEntity accountEntity);
    AccountEntity toEntity(Account account);

    void updateModel(@MappingTarget Account account, AccountEntity accountEntity);
}
