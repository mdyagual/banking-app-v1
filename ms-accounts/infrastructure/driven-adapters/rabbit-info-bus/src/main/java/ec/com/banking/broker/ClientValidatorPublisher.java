package ec.com.banking.broker;

import ec.com.banking.core.gateway.BusMessageBroker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientValidatorPublisher implements BusMessageBroker {
    private final RabbitTemplate rabbitTemplate;


    @Value("${rabbitmq.client-check.exchange}")
    private String exchange;

    @Value("${rabbitmq.client-check.routing-key}")
    private String routingKey;

    public ClientValidatorPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Map<String, Object> validateClient(Long clientId) {
        @SuppressWarnings("unchecked")
        Map<String, Object> response = (Map<String, Object>) rabbitTemplate.convertSendAndReceive(
                "client.check.exchange",
                "client.check.routingkey",
                clientId
        );
        return response;

    }
}
