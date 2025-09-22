package ec.com.banking.usecase;

import ec.com.banking.gateway.ClientRepository;

public class DeleteClientUseCase {
    private final ClientRepository clientRepository;

    public DeleteClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(Long clientId) {
        clientRepository.delete(clientId);
    }
}
