package uk.ac.ebi.subs.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgentQueueConfig {

    /**
     * Queue for submission envelopes to be processed by biosamples
     * @return
     */
    @Bean
    Queue biosamplesQueue() {
        return new Queue(Queues.BIOSAMPLES_AGENT,true);
    }

    @Bean
    Binding biosamplesBinding(Queue biosamplesQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(biosamplesQueue).to(submissionExchange).with(Topics.SAMPLES_PROCESSING);
    }

    /**
     * Queue for submission envelopes to be processed by metabolights
     * @return
     */
    @Bean
    Queue metabolightsQueue() {
        return new Queue(Queues.METABOLIGHTS_AGENT,true);
    }

    @Bean
    Binding metabolightsBinding(Queue metabolightsQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(metabolightsQueue).to(submissionExchange).with(Topics.METABOLIGHTS_PROCESSING);
    }

    /**
     * Queue for submission envelopes to be processed by ENA
     * @return
     */
    @Bean Queue enaQueue() {
        return new Queue(Queues.ENA_AGENT,true);
    }

    @Bean
    Binding enaBinding(Queue enaQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(enaQueue).to(submissionExchange).with(Topics.ENA_PROCESSING);
    }

    /**
     * Queue for submission envelopes to be processed by ArrayExpress
     * @return
     */
    @Bean Queue aeQueue() {
        return new Queue(Queues.AE_AGENT,true);
    }

    @Bean
    Binding aeBinding(Queue aeQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(aeQueue).to(submissionExchange).with(Topics.AE_PROCESSING);
    }

    /**
     * Queue for submission envelopes that need supporting information (samples)
     * @return
     */
    @Bean Queue sampleSuppInfoQueue() {return new Queue(Queues.SUBMISSION_NEEDS_SAMPLE_INFO,true); }

    @Bean Binding sampleSuppInfoBinding(Queue sampleSuppInfoQueue, TopicExchange submissionExchange){
        return BindingBuilder.bind(sampleSuppInfoQueue).to(submissionExchange).with(Queues.SUBMISSION_NEEDS_SAMPLE_INFO_ROUTING_KEY);
    }

    /**
     * Queue for updated samples envelopes to be used by ENA
     * @return
     */
    @Bean Queue enaSamplesUpdated() {return new Queue(Queues.ENA_SAMPLES_UPDATED,true);}

    @Bean
    Binding enaSamplesUpdatedBinding(Queue enaSamplesUpdated, TopicExchange submissionExchange) {
        return BindingBuilder.bind(enaSamplesUpdated).to(submissionExchange).with(Queues.SAMPLES_UPDATED_ROUTING_KEY);
    }

    /**
     * Queue for updated samples envelopes to be used by Metabolights
     * @return
     */
    @Bean Queue metabolightsSamplesUpdated() {return new Queue(Queues.METABOLIGHTS_SAMPLES_UPDATED,true);}

    @Bean
    Binding metabolightsSamplesUpdatedBinding(Queue metabolightsSamplesUpdated, TopicExchange submissionExchange) {
        return BindingBuilder.bind(metabolightsSamplesUpdated).to(submissionExchange).with(Queues.SAMPLES_UPDATED_ROUTING_KEY);
    }


    /**
     * Queue for updated sample envelopes to be used by AE
     * @return
     */
    @Bean Queue aeSamplesUpdated() {return new Queue(Queues.AE_SAMPLES_UPDATED,true);}

    @Bean
    Binding aeSamplesUpdatedBinding(Queue aeSamplesUpdated, TopicExchange submissionExchange) {
        return BindingBuilder.bind(aeSamplesUpdated).to(submissionExchange).with(Queues.SAMPLES_UPDATED_ROUTING_KEY);
    }
}
