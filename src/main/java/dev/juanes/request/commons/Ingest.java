package dev.juanes.request.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingest {
    private final String action;
    @JsonProperty("etag")
    private final String eTag;
    private final String filename;

    public String getAction() {
        return action;
    }

    public String getETag() {
        return eTag;
    }

    public String getFilename() {
        return filename;
    }

    Ingest(Builder builder) {
        this.action = builder.action;
        this.eTag = builder.eTag;
        this.filename = builder.filename;
    }

    public static class Builder {
        private final String action = "ingest";
        @JsonProperty("etag")
        private String eTag;
        private String filename;

        public Builder withETag(String eTag) {
            this.eTag = eTag;
            return this;
        }

        public Builder withFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public Ingest build() {
            return new Ingest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
