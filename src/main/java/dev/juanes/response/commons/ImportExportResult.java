package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImportExportResult {
    private String filename;
    @JsonProperty("signed_url")
    private String singedUrl;
    @JsonProperty("final_bookmark")
    private String finalBookmark;
    @JsonProperty("num_queries")
    private Long numQueries;
    private Meta meta;

    public String getFilename() {
        return filename;
    }

    public String getSingedUrl() {
        return singedUrl;
    }

    public String getFinalBookmark() {
        return finalBookmark;
    }

    public Long getNumQueries() {
        return numQueries;
    }

    public Meta getMeta() {
        return meta;
    }
}
