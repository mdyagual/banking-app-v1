package ec.com.banking.web.mapper;


import ec.com.banking.model.Client;
import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.request.UpdateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", implementationName = "WebClientMapperImpl")
public interface IClientMapper {
    @Mapping(target="clientId", ignore = true)
    Client toDomain(CreateClientDTO clientDTO);
    ClientDTO toDTO(Client client);

    void updateDomain(@MappingTarget Client client, UpdateClientDTO clientDTO);
}
