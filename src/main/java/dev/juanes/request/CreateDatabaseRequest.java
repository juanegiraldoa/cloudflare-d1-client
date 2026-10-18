package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.commons.ReadReplication;
import dev.juanes.datatype.Jurisdiction;
import dev.juanes.datatype.Location;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateDatabaseRequest {
    private final String name;

    @JsonProperty("primary_location_hint")
    private final Location primaryLocationHint;

    private final Jurisdiction jurisdiction;

    @JsonProperty("read_replication")
    private final ReadReplication readReplication;

    public String getName() {
        return name;
    }

    @JsonProperty("primary_location_hint")
    public Location getPrimaryLocationHint() {
        return primaryLocationHint;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    @JsonProperty("read_replication")
    public ReadReplication getReadReplication() {
        return readReplication;
    }

    private CreateDatabaseRequest(Builder builder) {
        this.name = builder.name;
        this.primaryLocationHint = builder.primaryLocationHint;
        this.jurisdiction = builder.jurisdiction;
        this.readReplication = builder.readReplication;
    }

    public static class Builder {
        private String name;
        private Location primaryLocationHint;
        private Jurisdiction jurisdiction;
        private ReadReplication readReplication;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrimaryLocationHint(Location location) {
            this.primaryLocationHint = location;
            return this;
        }

        public Builder withJurisdiction(Jurisdiction jurisdiction) {
            this.jurisdiction = jurisdiction;
            return this;
        }

        public Builder withReadReplication(ReadReplication readReplication) {
            this.readReplication = readReplication;
            return this;
        }

        public CreateDatabaseRequest build() {
            return new CreateDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
