package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.OutputFormat;
import dev.juanes.request.commons.DumpOptions;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExportDatabaseAsSQLRequest {
    @JsonIgnore
    private final String databaseId;

    @JsonProperty("output_format")
    private final OutputFormat outputFormat;

    @JsonProperty("current_bookmark")
    private final String currentBookmark;

    @JsonProperty("dump_options")
    private final DumpOptions dumpOptions;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    @JsonProperty("output_format")
    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    @JsonProperty("current_bookmark")
    public String getCurrentBookmark() {
        return currentBookmark;
    }

    @JsonProperty("dump_options")
    public DumpOptions getDumpOptions() {
        return dumpOptions;
    }

    ExportDatabaseAsSQLRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.outputFormat = builder.outputFormat;
        this.currentBookmark = builder.currentBookmark;
        this.dumpOptions = builder.dumpOptions;
    }

    public static class Builder {
        private String databaseId;
        private OutputFormat outputFormat;
        private String currentBookmark;
        private DumpOptions dumpOptions;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

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
