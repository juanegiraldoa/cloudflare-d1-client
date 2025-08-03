package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.Location;

import java.util.List;

public class Result {
    @JsonProperty("created_at")
    private String createdAt;
    private String name;
    private String uuid;
    private String version;
    @JsonProperty("created_in_region")
    private String createdInRegion;
    @JsonProperty("file_size")
    private Long fileSize;
    @JsonProperty("num_tables")
    private Long numTables;
    @JsonProperty("primary_location_hint")
    private Location primaryLocationHint;
    @JsonProperty("running_in_region")
    private String runningInRegion;
    @JsonProperty("read_replication")
    private ReadReplication readReplication;
    @JsonProperty("at_bookmark")
    private String atBookmark;
    private String error;
    private List<String> messages;
    private String status;
    private Boolean success;
    private String type;
    private ImportExportResult result;
    private String filename;
    @JsonProperty("upload_url")
    private String uploadUrl;

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getVersion() {
        return version;
    }

    public String getCreatedInRegion() {
        return createdInRegion;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public Long getNumTables() {
        return numTables;
    }

    public Location getPrimaryLocationHint() {
        return primaryLocationHint;
    }

    public String getRunningInRegion() {
        return runningInRegion;
    }

    public ReadReplication getReadReplication() {
        return readReplication;
    }

    public String getAtBookmark() {
        return atBookmark;
    }

    public String getError() {
        return error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getType() {
        return type;
    }

    public ImportExportResult getResult() {
        return result;
    }

    public String getFilename() {
        return filename;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }
}
