package ec.com.banking.web.mapper;

import ec.com.banking.model.Account;
import ec.com.banking.web.dto.request.UpdateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "WebAccountMapperImpl")
public interface IAccountMapper {

    AccountDTO toDTO(Account account);

    void updateDomain(@MappingTarget Account account, UpdateAccountDTO accountDTO);
}
