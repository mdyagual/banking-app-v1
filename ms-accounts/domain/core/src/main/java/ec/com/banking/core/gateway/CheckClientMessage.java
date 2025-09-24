package ec.com.banking.core.gateway;

import java.util.Map;

public interface CheckClientMessage {
    Map<String, Object> obtain(Long clientId);
}
