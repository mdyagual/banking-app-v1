package ec.com.banking.web.mapper;

import ec.com.banking.model.Account;
import ec.com.banking.web.dto.request.CreateAccountDTO;
import ec.com.banking.web.dto.request.UpdateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "WebAccountMapperImpl")
public interface IAccountMapper {
    @Mapping(target="accountId", ignore = true)
    @Mapping(target="status", ignore = true)
    Account toDomain(CreateAccountDTO accountDTO);

    @Mapping(target = "transactions",
            expression = "java(account.getTransactions() == null ? java.util.Collections.emptyList() : account.getTransactions().stream().map(a -> a.getAccountId()).toList())")
    AccountDTO toDTO(Account account);

    void updateDomain(@MappingTarget Account account, UpdateAccountDTO accountDTO);
}
