package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExportResult {
    private String filename;
    @JsonProperty("signed_url")
    private String singedUrl;

    public String getFilename() {
        return filename;
    }

    public String getSingedUrl() {
        return singedUrl;
    }
}
