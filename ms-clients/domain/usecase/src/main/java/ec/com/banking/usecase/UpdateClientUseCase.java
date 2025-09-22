package ec.com.banking.usecase;

import ec.com.banking.gateway.ClientRepository;
import ec.com.banking.model.Client;

public class UpdateClientUseCase {
    private final ClientRepository clientRepository;

    public UpdateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {
        return clientRepository.update(client);
    }
}
