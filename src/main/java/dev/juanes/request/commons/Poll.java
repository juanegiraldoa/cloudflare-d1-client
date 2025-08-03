package dev.juanes.request.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {
    private final String action;
    @JsonProperty("current_bookmark")
    private final String currentBookmark;

    public String getAction() {
        return action;
    }

    public String getCurrentBookmark() {
        return currentBookmark;
    }

    Poll(Builder builder) {
        this.action = builder.action;
        this.currentBookmark = builder.currentBookmark;
    }

    public static class Builder {
        private final String action = "poll";
        private String currentBookmark;

        public Builder withCurrentBookmark(String currentBookmark) {
            this.currentBookmark = currentBookmark;
            return this;
        }

        public Poll build() {
            return new Poll(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
