package ec.com.banking.usecase;


import ec.com.banking.gateway.ClientRepository;
import ec.com.banking.model.Client;

public class GetClientByIdUseCase {
    private final ClientRepository clienteRepository;

    public GetClientByIdUseCase(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Client execute(Long clientId) {
        return clienteRepository.findById(clientId);
    }
}
