package org.juane.response.commons;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("created_at")
    private String createdAt;
    private String name;
    private String uuid;
    private String version;
    @SerializedName("created_in_region")
    private String createdInRegion;
    @SerializedName("file_size")
    private Long fileSize;
    @SerializedName("num_tables")
    private Long numTables;

    public String getCreatedAt() {
        return createdAt;
    }

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

    public String getCreatedInRegion() {
        return createdInRegion;
    }

    public void setCreatedInRegion(String createdInRegion) {
        this.createdInRegion = createdInRegion;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getNumTables() {
        return numTables;
    }

    public void setNumTables(Long numTables) {
        this.numTables = numTables;
    }
}
