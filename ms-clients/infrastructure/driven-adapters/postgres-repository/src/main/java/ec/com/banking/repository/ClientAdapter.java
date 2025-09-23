package ec.com.banking.repository;

import ec.com.banking.core.gateway.ClientRepository;

import ec.com.banking.model.Client;
import ec.com.banking.repository.config.IClientRepository;
import ec.com.banking.repository.mapper.IClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientAdapter implements ClientRepository {
    private final IClientRepository repository;
    private final IClientMapper mapper;

    public ClientAdapter(IClientRepository repository, IClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Client findById(Long clientId) {
        return mapper.toModel(repository.findById(clientId).orElse(null));

    }

    @Override
    public Client save(Client client) {
        return mapper.toModel(repository.save(mapper.toEntity(client)));
    }

    @Override
    public Client update(Client client) {
        return mapper.toModel(repository.save(mapper.toEntity(client)));
    }

    @Override
    public void delete(Long clientId) {
        repository.deleteById(clientId);
    }

    @Override
    public boolean existsByIdNumber(String idNumber) {
        return repository.existsByIdNumber(idNumber);
    }
}
