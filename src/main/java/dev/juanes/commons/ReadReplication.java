package dev.juanes.commons;

import dev.juanes.datatype.Mode;

public class ReadReplication {
    private final Mode mode;

    public Mode getMode() {
        return mode;
    }

    ReadReplication(Builder builder) {
        this.mode = builder.mode;
    }

    public static class Builder {
        private Mode mode;

        public Builder withMode(Mode mode) {
            this.mode = mode;
            return this;
        }

        public ReadReplication build() {
            return new ReadReplication(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
