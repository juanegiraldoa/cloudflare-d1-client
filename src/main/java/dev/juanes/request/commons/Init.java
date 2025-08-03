package dev.juanes.request.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Init {
    private final String action;
    @JsonProperty("etag")
    private final String eTag;

    public String getAction() {
        return action;
    }

    public String geteTag() {
        return eTag;
    }

    Init(Builder builder) {
        this.action = builder.action;
        this.eTag = builder.eTag;
    }

    public static class Builder {
        private final String action = "init";
        @JsonProperty("etag")
        private String eTag;

        public Builder withETag(String eTag) {
            this.eTag = eTag;
            return this;
        }

        public Init build() {
            return new Init(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
