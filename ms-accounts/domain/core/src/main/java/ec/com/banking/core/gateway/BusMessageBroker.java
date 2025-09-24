package ec.com.banking.core.gateway;

import java.util.Map;

public interface BusMessageBroker {
    Map<String, Object>  validateClient(Long clientId);
}
