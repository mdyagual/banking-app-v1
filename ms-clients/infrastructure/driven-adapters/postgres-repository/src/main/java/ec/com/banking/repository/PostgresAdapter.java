package ec.com.banking.repository;

import ec.com.banking.gateway.ClientRepository;

import ec.com.banking.model.Client;
import ec.com.banking.repository.config.IPostgresRepository;
import ec.com.banking.repository.mapper.IClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresAdapter implements ClientRepository {
    private final IPostgresRepository repository;
    private final IClientMapper mapper;

    public PostgresAdapter(IPostgresRepository repository, IClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Client> getAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Client findById(Long clientId) {
        return mapper.toModel(repository.findById(clientId).get());

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
}
