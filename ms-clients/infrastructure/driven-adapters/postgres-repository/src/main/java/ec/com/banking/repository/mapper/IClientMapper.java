package ec.com.banking.repository.mapper;

import ec.com.banking.model.Client;
import ec.com.banking.repository.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    Client toModel(ClientEntity clientEntity);
    ClientEntity toEntity(Client client);
}
