package dev.juanes.request.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DumpOptions {
    @JsonProperty("no_data")
    private final Boolean noData;

    @JsonProperty("no_schema")
    private final Boolean noSchema;

    private final List<String> tables;

    @JsonProperty("no_data")
    public Boolean getNoData() {
        return noData;
    }

    @JsonProperty("no_schema")
    public Boolean getNoSchema() {
        return noSchema;
    }

    public List<String> getTables() {
        return tables;
    }

    DumpOptions(Builder builder) {
        this.noData = builder.noData;
        this.noSchema = builder.noSchema;
        this.tables = builder.tables;
    }

    public static class Builder {
        private Boolean noData;
        private Boolean noSchema;
        private List<String> tables;

        public Builder withNoData(Boolean noData) {
            this.noData = noData;
            return this;
        }

        public Builder withNoSchema(Boolean noSchema) {
            this.noSchema = noSchema;
            return this;
        }

        public Builder withTables(List<String> tables) {
            this.tables = tables;
            return this;
        }

        public DumpOptions build() {
            return new DumpOptions(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
