package uk.ac.ebi.subs.messaging;

/**
 * Created by davidr on 25/08/2016.
 */
public class Topics {


    /**
     * The User has submitted a Submission
     */
    public static final String EVENT_SUBMISSION_SUBMITTED = "usi.submission.submitted";


    /**
     * The User has deleted a Submission
     */
    public static final String EVENT_SUBMISSION_DELETED = "usi.submission.deleted";

    /**
     * The User has created a Submission
     */
    public static final String EVENT_SUBMISSION_CREATED = "usi.submission.created";


    /**
     * The monitor has updated a Submission
     */
    public static final String EVENT_SUBMISSION_UPDATED = "usi.submission.updated";


    /**
     * The monitor has updated a Submission
     */
    public static final String EVENT_SUBMISSION_PROCESSING_UPDATED = "usi.submission.processingupdated";


    /**
     * An Agent has produced AgentResults
     */
    public static final String EVENT_SUBMISSION_AGENT_RESULTS = "usi.agentresults.produced";


    /**
     * Supporting information required from BioSamples
     */
    public static final String EVENT_SUBMISSION_NEEDS_SAMPLES = "usi.submissionenvelope.supportinginformation.samples";

    /**
     * Samples have been updated in BioSamples
     */
    public static final String EVENT_SAMPLES_UPDATED = "usi.updatedsamplesenvelope.samplesupdated";

    /**
     * Supporting information provided
     */
    public static final String EVENT_SUBISSION_SUPPORTING_INFO_PROVIDED = "usi.submissionenvelope.supportinginformation.provided";

    /**
     * Samples processing required
     */
    public static final String SAMPLES_PROCESSING = "usi.submissionenvelope.dispatched.biosamples";

    /**
     * Samples processing required
     */
    public static final String BIOSTUDIES_PROCESSING = "usi.submissionenvelope.dispatched.biostudies";


    /**
     * ENA processing required
     */
    public static final String ENA_PROCESSING = "usi.submissionenvelope.dispatched.ena";

    /**
     * AE processing required
     */
    public static final String AE_PROCESSING = "usi.submissionenvelope.dispatched.arrayexpress";

    /**
     * ML processing required
     */
    public static final String METABOLIGHTS_PROCESSING = "usi.submissionenvelope.dispatched.metabolights";

    public static final String GLOBUS_SHARE_REQUEST = "usi.fu.globus.share.request";
    public static final String GLOBUS_UPLOADED_FILES_NOTIFICATION = "usi.fu.globus.notification.uploadedfiles";
}
