package ec.com.banking.usecase;

import ec.com.banking.core.gateway.ClientRepository;
import ec.com.banking.model.Client;
import ec.com.banking.core.exception.ClientDuplicatedException;

public class SaveClientUseCase {
    private final ClientRepository clientRepository;

    public SaveClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {
        if(clientRepository.existsByIdNumber(client.getIdNumber())){
            throw new ClientDuplicatedException(client.getIdNumber());
        }
        return clientRepository.save(client);
    }
}
