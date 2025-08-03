package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.OutputFormat;
import dev.juanes.request.commons.DumpOptions;

public class ExportDatabaseAsSQLRequest {
    @JsonProperty("output_format")
    private final OutputFormat outputFormat;
    @JsonProperty("current_bookmark")
    private final String currentBookmark;
    @JsonProperty("dump_options")
    private final DumpOptions dumpOptions;

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public String getCurrentBookmark() {
        return currentBookmark;
    }

    public DumpOptions getDumpOptions() {
        return dumpOptions;
    }

    ExportDatabaseAsSQLRequest(Builder builder) {
        this.outputFormat = builder.outputFormat;
        this.currentBookmark = builder.currentBookmark;
        this.dumpOptions = builder.dumpOptions;
    }

    public static class Builder {
        private OutputFormat outputFormat;
        private String currentBookmark;
        private DumpOptions dumpOptions;

        public Builder withOutputFormat(OutputFormat outputFormat) {
            this.outputFormat = outputFormat;
            return this;
        }

        public Builder withCurrentBookmark(String currentBookmark) {
            this.currentBookmark = currentBookmark;
            return this;
        }

        public Builder withDumpOptions(DumpOptions dumpOptions) {
            this.dumpOptions = dumpOptions;
            return this;
        }

        public ExportDatabaseAsSQLRequest build() {
            return new ExportDatabaseAsSQLRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
