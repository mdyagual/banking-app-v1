package ec.com.banking.broker;

import ec.com.banking.core.gateway.ClientRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientValidatorListener {
    private final RabbitTemplate rabbitTemplate;
    private final ClientRepository clientRepository;

    public ClientValidatorListener(RabbitTemplate rabbitTemplate, ClientRepository clientRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.clientRepository = clientRepository;
    }

    @RabbitListener(queues = "${rabbitmq.client-check.queue}")
    public Map<String, Object> handleValidateClient(String clientId) {
        return Map.of("exists", clientRepository.findById(Long.parseLong(clientId))!=null);
    }
}
