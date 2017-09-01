package uk.ac.ebi.subs.messaging;


class Exchanges {

    private static final String USI_CONTRACT_VERSION = "usi-1";

    static final String SUBMISSIONS = USI_CONTRACT_VERSION+":submission-exchange";

    static final String DEAD_LETTER_EXCHANGE = USI_CONTRACT_VERSION+":dead-letter-exchange";
}
