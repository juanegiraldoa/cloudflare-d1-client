package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Message {
    private Integer code;
    private String message;

    @JsonProperty("documentation_url")
    private String documentationUrl;

    private Map<String, Object> source;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("documentation_url")
    public String getDocumentationUrl() {
        return documentationUrl;
    }

    @JsonProperty("documentation_url")
    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public void setSource(Map<String, Object> source) {
        this.source = source;
    }
}
