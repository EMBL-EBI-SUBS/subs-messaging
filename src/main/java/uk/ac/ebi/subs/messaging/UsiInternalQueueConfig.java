package uk.ac.ebi.subs.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is responsible for the configuration of the USI internal queues.
 */
@Configuration
public class UsiInternalQueueConfig {

    /**
     * Queue for certificate envelopes to update submission state
     *
     * @return
     */
    @Bean
    Queue monitorQueue() {
        return Queues.buildQueueWithDlx(Queues.SUBMISSION_MONITOR);
    }

    @Bean
    Binding monitorBinding(Queue monitorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(monitorQueue).to(submissionExchange).with(Queues.SUBMISSION_MONITOR_ROUTING_KEY);
    }

    /**
     * Queue for submission envelopes that have had supporting information added
     *
     * @return
     */
    @Bean
    Queue suppInfoProvidedQueue() {
        return Queues.buildQueueWithDlx(Queues.SUBMISSION_SUPPORTING_INFO_PROVIDED);
    }

    @Bean
    Binding suppInfoProvidedBinding(Queue suppInfoProvidedQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(suppInfoProvidedQueue).to(submissionExchange).with(Queues.SUBMISSION_SUPPORTING_INFO_PROVIDED_ROUTING_KEY    );
    }

}
