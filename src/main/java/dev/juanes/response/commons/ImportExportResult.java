package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImportExportResult {
    private String filename;

    @JsonProperty("signed_url")
    private String signedUrl;

    @JsonProperty("final_bookmark")
    private String finalBookmark;

    @JsonProperty("num_queries")
    private Long numQueries;

    private Meta meta;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("signed_url")
    public String getSignedUrl() {
        return signedUrl;
    }

    @JsonProperty("signed_url")
    public void setSignedUrl(String signedUrl) {
        this.signedUrl = signedUrl;
    }

    @JsonProperty("final_bookmark")
    public String getFinalBookmark() {
        return finalBookmark;
    }

    @JsonProperty("final_bookmark")
    public void setFinalBookmark(String finalBookmark) {
        this.finalBookmark = finalBookmark;
    }

    @JsonProperty("num_queries")
    public Long getNumQueries() {
        return numQueries;
    }

    @JsonProperty("num_queries")
    public void setNumQueries(Long numQueries) {
        this.numQueries = numQueries;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
