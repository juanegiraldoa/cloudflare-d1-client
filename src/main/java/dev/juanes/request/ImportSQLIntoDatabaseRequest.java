package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.request.commons.Ingest;
import dev.juanes.request.commons.Init;
import dev.juanes.request.commons.Poll;

public class ImportSQLIntoDatabaseRequest {
    @JsonProperty("Init")
    private final Init init;
    @JsonProperty("Ingest")
    private final Ingest ingest;
    @JsonProperty("Poll")
    private final Poll poll;

    public Init getInit() {
        return init;
    }

    public Ingest getIngest() {
        return ingest;
    }

    public Poll getPoll() {
        return poll;
    }

    ImportSQLIntoDatabaseRequest(Builder builder) {
        this.init = builder.init;
        this.ingest = builder.ingest;
        this.poll = builder.poll;
    }

    public static class Builder {
        private Init init;
        private Ingest ingest;
        private Poll poll;

        public Builder withInit(Init init) {
            this.init = init;
            return this;
        }

        public Builder withIngest(Ingest ingest) {
            this.ingest = ingest;
            return this;
        }

        public Builder withPoll(Poll poll) {
            this.poll = poll;
            return this;
        }

        public ImportSQLIntoDatabaseRequest build() {
            return new ImportSQLIntoDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
