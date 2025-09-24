package ec.com.banking.core.gateway;

import java.util.Map;

public interface BusListenerBroker {
    void receiveRequest(Map<String, Object> message);
}
