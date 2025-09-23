package ec.com.banking.web.handler;

import ec.com.banking.usecase.account.*;
import ec.com.banking.web.dto.request.CreateAccountDTO;
import ec.com.banking.web.dto.request.UpdateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import ec.com.banking.web.mapper.IAccountMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountHandler {
    private final GetAllAccountsUseCase getAllAccountsUseCase;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final SaveAccountUseCase saveAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;

    private final IAccountMapper mapper;

    public AccountHandler(GetAllAccountsUseCase getAllAccountsUseCase,
                          GetAccountByIdUseCase getAccountByIdUseCase,
                          SaveAccountUseCase saveAccountUseCase,
                          UpdateAccountUseCase updateAccountUseCase,
                          DeleteAccountUseCase deleteAccountUseCase,
                          IAccountMapper mapper) {
        this.getAllAccountsUseCase = getAllAccountsUseCase;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.saveAccountUseCase = saveAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.mapper = mapper;
    }

    public List<AccountDTO> findAll() {
        return getAllAccountsUseCase.execute().stream().map(mapper::toDTO).toList();
    }

    public AccountDTO findById(Long id) {
        return mapper.toDTO(getAccountByIdUseCase.execute(id));
    }
    public AccountDTO save(CreateAccountDTO accountDTO) {
        var account = mapper.toDomain(accountDTO);
        return mapper.toDTO(saveAccountUseCase.execute(account));
    }

    public AccountDTO update(UpdateAccountDTO accountDTO) {
        var account = getAccountByIdUseCase.execute(accountDTO.getAccountId());
        mapper.updateDomain(account, accountDTO);
        return mapper.toDTO(updateAccountUseCase.execute(account));
    }

    public void delete(Long id) {
        deleteAccountUseCase.execute(id);
    }
}
