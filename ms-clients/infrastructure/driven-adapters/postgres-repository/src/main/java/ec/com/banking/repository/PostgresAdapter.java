package ec.com.banking.repository;

import ec.com.banking.gateway.ClientRepository;

import ec.com.banking.model.Client;
import ec.com.banking.repository.config.IPostgresRepository;
import ec.com.banking.repository.mapper.IClientMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresAdapter implements ClientRepository {
    private final IPostgresRepository repository;
    private final IClientMapper mapper;

    public PostgresAdapter(IPostgresRepository repository, IClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Client findById(Long clientId) {
        return null;
    }

    @Override
    public Client save(Client client) {
        return mapper.toModel(repository.save(mapper.toEntity(client)));
    }
}
