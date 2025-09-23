package ec.com.banking.usecase;

import ec.com.banking.core.gateway.ClientRepository;
import ec.com.banking.core.exception.ClientNotFoundException;

public class DeleteClientUseCase {
    private final ClientRepository clientRepository;

    public DeleteClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(Long clientId) {
        if(clientRepository.findById(clientId) == null){
            throw new ClientNotFoundException(clientId);
        }
        clientRepository.delete(clientId);
    }
}
