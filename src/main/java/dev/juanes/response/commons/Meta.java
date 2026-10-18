package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.Region;

public class Meta {
    @JsonProperty("served_by_colo")
    private String servedByColo;

    private Double duration;
    private Long changes;

    @JsonProperty("last_row_id")
    private Long lastRowId;

    @JsonProperty("changed_db")
    private Boolean changedDb;

    @JsonProperty("size_after")
    private Long sizeAfter;

    @JsonProperty("rows_read")
    private Long rowsRead;

    @JsonProperty("rows_written")
    private Long rowsWritten;

    @JsonProperty("served_by_region")
    private Region servedByRegion;

    @JsonProperty("served_by_primary")
    private Boolean servedByPrimary;

    private Timings timings;

    @JsonProperty("read_replication")
    private ReadReplication readReplication;

    @JsonProperty("total_attempts")
    private Long totalAttempts;

    @JsonProperty("served_by_colo")
    public String getServedByColo() {
        return servedByColo;
    }

    @JsonProperty("served_by_colo")
    public void setServedByColo(String servedByColo) {
        this.servedByColo = servedByColo;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getChanges() {
        return changes;
    }

    public void setChanges(Long changes) {
        this.changes = changes;
    }

    @JsonProperty("last_row_id")
    public Long getLastRowId() {
        return lastRowId;
    }

    @JsonProperty("last_row_id")
    public void setLastRowId(Long lastRowId) {
        this.lastRowId = lastRowId;
    }

    @JsonProperty("changed_db")
    public Boolean getChangedDb() {
        return changedDb;
    }

    @JsonProperty("changed_db")
    public void setChangedDb(Boolean changedDb) {
        this.changedDb = changedDb;
    }

    @JsonProperty("size_after")
    public Long getSizeAfter() {
        return sizeAfter;
    }

    @JsonProperty("size_after")
    public void setSizeAfter(Long sizeAfter) {
        this.sizeAfter = sizeAfter;
    }

    @JsonProperty("rows_read")
    public Long getRowsRead() {
        return rowsRead;
    }

    @JsonProperty("rows_read")
    public void setRowsRead(Long rowsRead) {
        this.rowsRead = rowsRead;
    }

    @JsonProperty("rows_written")
    public Long getRowsWritten() {
        return rowsWritten;
    }

    @JsonProperty("rows_written")
    public void setRowsWritten(Long rowsWritten) {
        this.rowsWritten = rowsWritten;
    }

    @JsonProperty("served_by_region")
    public Region getServedByRegion() {
        return servedByRegion;
    }

    @JsonProperty("served_by_region")
    public void setServedByRegion(Region servedByRegion) {
        this.servedByRegion = servedByRegion;
    }

    @JsonProperty("served_by_primary")
    public Boolean getServedByPrimary() {
        return servedByPrimary;
    }

    @JsonProperty("served_by_primary")
    public void setServedByPrimary(Boolean servedByPrimary) {
        this.servedByPrimary = servedByPrimary;
    }

    public Timings getTimings() {
        return timings;
    }

    public void setTimings(Timings timings) {
        this.timings = timings;
    }

    @JsonProperty("read_replication")
    public ReadReplication getReadReplication() {
        return readReplication;
    }

    @JsonProperty("read_replication")
    public void setReadReplication(ReadReplication readReplication) {
        this.readReplication = readReplication;
    }

    @JsonProperty("total_attempts")
    public Long getTotalAttempts() {
        return totalAttempts;
    }

    @JsonProperty("total_attempts")
    public void setTotalAttempts(Long totalAttempts) {
        this.totalAttempts = totalAttempts;
    }
}
