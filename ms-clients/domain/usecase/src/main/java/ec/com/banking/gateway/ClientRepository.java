package ec.com.banking.gateway;


import ec.com.banking.model.Client;

public interface ClientRepository {
    Client findById(Long clientId);
    Client save(Client client);
}
