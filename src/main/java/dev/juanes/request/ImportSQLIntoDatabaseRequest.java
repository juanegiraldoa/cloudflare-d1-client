package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.juanes.request.commons.Ingest;
import dev.juanes.request.commons.Init;
import dev.juanes.request.commons.Poll;

import java.util.Collections;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportSQLIntoDatabaseRequest {
    @JsonIgnore
    private final String databaseId;

    private final Init init;
    private final Ingest ingest;
    private final Poll poll;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    @JsonIgnore
    public Init getInit() {
        return init;
    }

    @JsonIgnore
    public Ingest getIngest() {
        return ingest;
    }

    @JsonIgnore
    public Poll getPoll() {
        return poll;
    }

    /**
     * The D1 import endpoint expects a flat object with the selected action,
     * not a nested {@code Init}/{@code Ingest}/{@code Poll} object.
     */
    @JsonValue
    public Object asBody() {
        if (init != null) {
            return init;
        }
        if (ingest != null) {
            return ingest;
        }
        if (poll != null) {
            return poll;
        }
        return Collections.emptyMap();
    }

    ImportSQLIntoDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.init = builder.init;
        this.ingest = builder.ingest;
        this.poll = builder.poll;
    }

    public static class Builder {
        private String databaseId;
        private Init init;
        private Ingest ingest;
        private Poll poll;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

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
