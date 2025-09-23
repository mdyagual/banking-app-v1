package ec.com.banking.core.gateway;


import ec.com.banking.model.Client;

import java.util.List;

public interface ClientRepository {
    //CRUD METHODS
    List<Client> getAll();
    Client findById(Long clientId);
    Client save(Client client);
    Client update(Client client);
    void delete(Long clientId);

    //EXIST METHODS
    boolean existsByIdNumber(String idNumber);

}
