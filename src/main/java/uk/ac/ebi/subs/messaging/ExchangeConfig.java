package uk.ac.ebi.subs.messaging;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Exchange config - setup a topic exchange for submissions
 */
@Configuration
public class ExchangeConfig {

    /**
     * The Exchange for usi submissions
     * @return an instance of {@link TopicExchange} for USI submissions.
     */
    @Bean
    public TopicExchange submissionExchange() {
        return new TopicExchange(Exchanges.SUBMISSIONS);
    }

    /**
     * The Dead letter exchange for usi submissions
     * @return an instance of {@link TopicExchange} for invalid messages related to USI submissions.
     */
    @Bean
    public TopicExchange deadLetterExchange() { return new TopicExchange(Exchanges.DEAD_LETTER_EXCHANGE); }
}
