package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.Location;

public class CreateDatabaseRequest {
    private final String name;
    @JsonProperty("primary_location_hint")
    private final Location primaryLocationHint;

    public String getName() {
        return name;
    }

    public Location getPrimaryLocationHint() {
        return primaryLocationHint;
    }

    private CreateDatabaseRequest(Builder builder) {
        this.name = builder.name;
        this.primaryLocationHint = builder.primaryLocationHint;
    }

    public static class Builder {
        private String name;
        private Location primaryLocationHint;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrimaryLocationHint(Location location) {
            this.primaryLocationHint = location;
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
