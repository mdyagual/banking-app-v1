package ec.com.banking.usecase;

import ec.com.banking.core.gateway.ClientRepository;
import ec.com.banking.model.Client;
import ec.com.banking.core.exception.ClientNotFoundException;

public class UpdateClientUseCase {
    private final ClientRepository clientRepository;

    public UpdateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {
        if(clientRepository.findById(client.getClientId()) == null){
            throw new ClientNotFoundException(client.getClientId());
        }
        return clientRepository.update(client);
    }
}
