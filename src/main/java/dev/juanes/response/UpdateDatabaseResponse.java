package dev.juanes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.response.commons.Message;
import dev.juanes.response.commons.ReadReplication;

public class UpdateDatabaseResponse {
    private boolean success;
    private Message[] errors;
    private Message[] messages;
    private Result result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Message[] getErrors() {
        return errors;
    }

    public void setErrors(Message[] errors) {
        this.errors = errors;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("file_size")
        private long fileSize;

        private String name;

        @JsonProperty("num_tables")
        private int numTables;

        private String uuid;

        private String version;

        @JsonProperty("read_replication")
        private ReadReplication readReplication;

        @JsonProperty("primary_location_hint")
        private String primaryLocationHint;

        @JsonProperty("jurisdiction")
        private String jurisdiction;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumTables() {
            return numTables;
        }

        public void setNumTables(int numTables) {
            this.numTables = numTables;
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

        public ReadReplication getReadReplication() {
            return readReplication;
        }

        public void setReadReplication(ReadReplication readReplication) {
            this.readReplication = readReplication;
        }

        public String getPrimaryLocationHint() {
            return primaryLocationHint;
        }

        public void setPrimaryLocationHint(String primaryLocationHint) {
            this.primaryLocationHint = primaryLocationHint;
        }

        public String getJurisdiction() {
            return jurisdiction;
        }

        public void setJurisdiction(String jurisdiction) {
            this.jurisdiction = jurisdiction;
        }
    }
}
