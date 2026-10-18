package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.Jurisdiction;
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

    private Jurisdiction jurisdiction;

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

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("created_in_region")
    public String getCreatedInRegion() {
        return createdInRegion;
    }

    @JsonProperty("created_in_region")
    public void setCreatedInRegion(String createdInRegion) {
        this.createdInRegion = createdInRegion;
    }

    @JsonProperty("file_size")
    public Long getFileSize() {
        return fileSize;
    }

    @JsonProperty("file_size")
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @JsonProperty("num_tables")
    public Long getNumTables() {
        return numTables;
    }

    @JsonProperty("num_tables")
    public void setNumTables(Long numTables) {
        this.numTables = numTables;
    }

    @JsonProperty("primary_location_hint")
    public Location getPrimaryLocationHint() {
        return primaryLocationHint;
    }

    @JsonProperty("primary_location_hint")
    public void setPrimaryLocationHint(Location primaryLocationHint) {
        this.primaryLocationHint = primaryLocationHint;
    }

    @JsonProperty("running_in_region")
    public String getRunningInRegion() {
        return runningInRegion;
    }

    @JsonProperty("running_in_region")
    public void setRunningInRegion(String runningInRegion) {
        this.runningInRegion = runningInRegion;
    }

    @JsonProperty("read_replication")
    public ReadReplication getReadReplication() {
        return readReplication;
    }

    @JsonProperty("read_replication")
    public void setReadReplication(ReadReplication readReplication) {
        this.readReplication = readReplication;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @JsonProperty("at_bookmark")
    public String getAtBookmark() {
        return atBookmark;
    }

    @JsonProperty("at_bookmark")
    public void setAtBookmark(String atBookmark) {
        this.atBookmark = atBookmark;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImportExportResult getResult() {
        return result;
    }

    public void setResult(ImportExportResult result) {
        this.result = result;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("upload_url")
    public String getUploadUrl() {
        return uploadUrl;
    }

    @JsonProperty("upload_url")
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }
}
