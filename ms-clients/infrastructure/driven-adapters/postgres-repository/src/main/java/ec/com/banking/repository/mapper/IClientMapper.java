package ec.com.banking.repository.mapper;

import ec.com.banking.model.Client;
import ec.com.banking.repository.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "RepositoryClientMapperImpl")
public interface IClientMapper {
    Client toModel(ClientEntity clientEntity);
    ClientEntity toEntity(Client client);

    void updateModel(@MappingTarget Client client, ClientEntity clientEntity);
}
