package ec.com.banking.web.mapper;


import ec.com.banking.model.Client;
import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    Client toDomain(CreateClientDTO clientDTO);
    ClientDTO toDTO(Client client);
}
