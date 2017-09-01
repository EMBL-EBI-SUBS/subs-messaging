package uk.ac.ebi.subs.messaging;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadLetterQueueConfig {

    /**
     * Instantiate a {@code Queue} for validate submissions.
     *
     * @return an instance of a {@code Queue} for validate submissions.
     */
    @Bean
    Queue submissionDeadLetterQueue() { return QueueBuilder.durable(Queues.SUBMISSION_DEAD_LETTER).build(); }


    /**
     * Create a {@code Binding} between the submission's dead letter exchange and dead letter queue using the routing key of created submissions.
     *
     * @param submissionDeadLetterQueue {@code Queue} for storing the invalid messages
     * @param deadLetterExchange {@code TopicExchange} for dead letters (messages)
     * @return a {@code Binding} between the dead letter exchange and dead letter queue
     * using the '#' routing key, which can substitute for zero or more words, so basically all the existing routing keys.
     */
    @Bean
    Binding deadLetterForSubmissionsBinding(Queue submissionDeadLetterQueue, TopicExchange deadLetterExchange) {
        return BindingBuilder.bind(submissionDeadLetterQueue).to(deadLetterExchange)
                .with(Queues.SUBMISSION_DEAD_LETTER_ROUTING_KEY);
    }
}
