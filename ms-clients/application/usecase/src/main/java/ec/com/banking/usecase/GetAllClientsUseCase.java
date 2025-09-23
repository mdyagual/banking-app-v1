package ec.com.banking.usecase;

import ec.com.banking.core.gateway.ClientRepository;
import ec.com.banking.model.Client;

import java.util.List;

public class GetAllClientsUseCase {
    private final ClientRepository clientRepository;

    public GetAllClientsUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> execute() {
        return clientRepository.getAll();
    }
}
