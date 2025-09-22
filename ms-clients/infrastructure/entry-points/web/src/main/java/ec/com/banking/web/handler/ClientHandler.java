package ec.com.banking.web.handler;

import ec.com.banking.model.Client;
import ec.com.banking.usecase.*;
import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.request.UpdateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import ec.com.banking.web.mapper.IClientMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientHandler {
    private final GetAllClientsUseCase getAllClientsUseCase;
    private final GetClientByIdUseCase getClientByIdUseCase;
    private final SaveClientUseCase saveClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;

    private final IClientMapper mapper;

    public ClientHandler(GetAllClientsUseCase getAllClientsUseCase,
                         GetClientByIdUseCase getClientByIdUseCase,
                         SaveClientUseCase saveClientUseCase,
                         UpdateClientUseCase updateClientUseCase,
                         DeleteClientUseCase deleteClientUseCase,
                         IClientMapper mapper) {
        this.getAllClientsUseCase = getAllClientsUseCase;
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.saveClientUseCase = saveClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.mapper = mapper;
    }

    public List<ClientDTO> findAll() {
        return getAllClientsUseCase.execute().stream().map(mapper::toDTO).toList();
    }

    public ClientDTO findById(Long id) {
        return mapper.toDTO(getClientByIdUseCase.execute(id));
    }

    public ClientDTO save(CreateClientDTO clientDTO) {
        return mapper.toDTO(saveClientUseCase.execute(mapper.toDomain(clientDTO)));
    }

    public ClientDTO update(UpdateClientDTO clientDTO) {
        Client c = getClientByIdUseCase.execute(clientDTO.getClientId());
        mapper.updateDomain(c, clientDTO);
        return mapper.toDTO(updateClientUseCase.execute(c));

    }

    public void delete(Long id) {
        deleteClientUseCase.execute(id);
    }



}
