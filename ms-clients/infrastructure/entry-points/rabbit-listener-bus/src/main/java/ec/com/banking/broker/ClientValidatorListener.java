package ec.com.banking.broker;

import ec.com.banking.core.gateway.ClientRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientValidatorListener {
    private final ClientRepository clientRepository;

    public ClientValidatorListener(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RabbitListener(queues = "${rabbitmq.client-check.queue}")
    public Map<String, Object> handleValidateClient(String clientId) {
        return new HashMap<>(){{
            put("exists", clientRepository.findById(Long.parseLong(clientId))!=null);
            put("name", clientRepository.findById(Long.parseLong(clientId)).getName());
        }};

    }
}
