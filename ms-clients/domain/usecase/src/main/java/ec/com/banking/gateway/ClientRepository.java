package ec.com.banking.gateway;


import ec.com.banking.model.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getAll();
    Client findById(Long clientId);
    Client save(Client client);
    Client update(Client client);
    void delete(Long clientId);
}
