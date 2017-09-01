package uk.ac.ebi.subs.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;

public class Queues {

    public static final String SUBMISSION_SUBMITTED_ROUTING_KEY = Topics.EVENT_SUBMISSION_SUBMITTED;
    public static final String SUBMISSION_SUBMITTED_CHECK_SUPPORTING_INFO = "usi-submission-submitted-check-supp-info";
    public static final String SUBMISSION_SUBMITTED_MARK_SUBMITTABLES = "usi-submission-submitted-mark-submittables";
    public static final String SUBMISSION_SUBMITTED_DO_DISPATCH = "usi-submission-submitted-do-dispatch";

    public static final String SUBMISSION_DELETED_CLEANUP_CONTENTS = "usi-submission-deleted-cleanup-contents";
    public static final String SUBMISSION_DELETED_ROUTING_KEY = Topics.EVENT_SUBMISSION_DELETED;


    public static final String SUBMISSION_MONITOR = "usi-submission-monitor";
    public static final String SUBMISSION_MONITOR_ROUTING_KEY = Topics.EVENT_SUBMISSION_AGENT_RESULTS;

    public static final String SUBMISSION_DISPATCHER = "usi-submission-dispatcher";

    public static final String SUBMISSION_PROCESSING_UPDATED_DISPATCHER_ROUTING_KEY = Topics.EVENT_SUBMISSION_PROCESSING_UPDATED;

    public static final String SUBMISSION_SUPPORTING_INFO_PROVIDED = "usi-submission-supp-inf-provided";
    public static final String SUBMISSION_SUPPORTING_INFO_PROVIDED_ROUTING_KEY = Topics.EVENT_SUBISSION_SUPPORTING_INFO_PROVIDED;


    public static final String SUBMISSION_NEEDS_SAMPLE_INFO = "usi-submission-support-biosamples";
    public static final String SUBMISSION_NEEDS_SAMPLE_INFO_ROUTING_KEY = Topics.EVENT_SUBMISSION_NEEDS_SAMPLES;

    public static final String SUBMISSION_VALIDATOR = "usi-submission-validator";
    public static final String SUBMISSION_VALIDATOR_SUBMISSION_CREATED_ROUTING_KEY = Topics.EVENT_SUBMISSION_CREATED;
    public static final String SUBMISSION_VALIDATOR_SUBMISSION_UPDATED_ROUTING_KEY = Topics.EVENT_SUBMISSION_UPDATED;

    public static final String BIOSAMPLES_AGENT = "usi-submission-agent-biosamples";
    public static final String ENA_AGENT = "usi-submission-agents-ena";
    public static final String AE_AGENT = "usi-submission-agents-arrayexpress";
    public static final String METABOLIGHTS_AGENT = "usi-submission-agents-metabolights";

    public static final String ENA_SAMPLES_UPDATED = "usi-submission-agents-ena-samples-updated";
    public static final String AE_SAMPLES_UPDATED = "usi-submission-agents-ae-samples-updated";
    public static final String METABOLIGHTS_SAMPLES_UPDATED = "usi-submission-agents-metabolights-samples-updated";
    public static final String SAMPLES_UPDATED_ROUTING_KEY = Topics.EVENT_SAMPLES_UPDATED;

    public static final String SUBMISSION_DEAD_LETTER = "usi-submission-dead-letter";
    public static final String SUBMISSION_DEAD_LETTER_ROUTING_KEY = "#";

    /**
     * Build an instance of a {@link Queue} configured with a Dead Letter Exchange.
     * @param queueName
     * @return
     */
    public static Queue buildQueueWithDlx(String queueName) {
        return QueueBuilder.durable(queueName)
                .withArgument("x-dead-letter-exchange", Exchanges.DEAD_LETTER_EXCHANGE)
                .build();
    }
}
