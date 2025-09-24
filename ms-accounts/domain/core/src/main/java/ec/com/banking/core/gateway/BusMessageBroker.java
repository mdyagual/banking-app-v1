package ec.com.banking.core.gateway;

import ec.com.banking.model.Account;

import java.util.Map;

public interface BusMessageBroker {
    Map<String, Object>  validateClient(Long clientId);
}
