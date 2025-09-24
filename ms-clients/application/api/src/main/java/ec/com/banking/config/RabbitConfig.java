package ec.com.banking.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String CLIENT_CHECK_QUEUE = "client.check.queue";
    public static final String CLIENT_CHECK_EXCHANGE = "client.check.exchange";
    public static final String CLIENT_CHECK_ROUTING_KEY = "client.check.routingkey";

    @Bean
    public Queue clientCheckQueue() {
        return new Queue(CLIENT_CHECK_QUEUE);
    }

    @Bean
    public DirectExchange clientCheckExchange() {
        return new DirectExchange(CLIENT_CHECK_EXCHANGE);
    }

    @Bean
    public Binding clientCheckBinding() {
        return BindingBuilder
                .bind(clientCheckQueue())
                .to(clientCheckExchange())
                .with(CLIENT_CHECK_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}