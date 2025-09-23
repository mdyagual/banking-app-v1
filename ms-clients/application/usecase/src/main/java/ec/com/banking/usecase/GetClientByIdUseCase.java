package ec.com.banking.usecase;


import ec.com.banking.core.gateway.ClientRepository;
import ec.com.banking.model.Client;
import ec.com.banking.core.exception.ClientNotFoundException;

public class GetClientByIdUseCase {
    private final ClientRepository clienteRepository;

    public GetClientByIdUseCase(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Client execute(Long clientId) {
        if (clienteRepository.findById(clientId) == null){
            throw new ClientNotFoundException(clientId);
        }
        return clienteRepository.findById(clientId);
    }
}
