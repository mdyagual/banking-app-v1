package ec.com.banking.usecase;

import ec.com.banking.gateway.ClientRepository;
import ec.com.banking.model.Client;

public class SaveClientUseCase {
    private final ClientRepository clientRepository;

    public SaveClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(Client client) {
        clientRepository.save(client);
    }
}
