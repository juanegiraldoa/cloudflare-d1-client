package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.datatype.Location;

public class Meta {
    @JsonProperty("served_by")
    private String servedBy;
    private Double duration;
    private Integer changes;
    @JsonProperty("last_row_id")
    private Integer lastRowId;
    @JsonProperty("changed_db")
    private Boolean changedDb;
    @JsonProperty("size_after")
    private Integer sizeAfter;
    @JsonProperty("rows_read")
    private Integer rowsRead;
    @JsonProperty("rows_written")
    private Integer rowsWritten;
    @JsonProperty("served_by_region")
    private Location servedByRegion;
    @JsonProperty("served_by_primary")
    private Boolean servedByPrimary;
    private Timings timings;
    @JsonProperty("read_replication")
    private ReadReplication readReplication;

    public String getServedBy() {
        return servedBy;
    }

    public Double getDuration() {
        return duration;
    }

    public Integer getChanges() {
        return changes;
    }

    public Integer getLastRowId() {
        return lastRowId;
    }

    public Boolean getChangedDb() {
        return changedDb;
    }

    public Integer getSizeAfter() {
        return sizeAfter;
    }

    public Integer getRowsRead() {
        return rowsRead;
    }

    public Integer getRowsWritten() {
        return rowsWritten;
    }

    public Location getServedByRegion() {
        return servedByRegion;
    }

    public Boolean getServedByPrimary() {
        return servedByPrimary;
    }

    public Timings getTimings() {
        return timings;
    }

    public ReadReplication getReadReplication() {
        return readReplication;
    }
}
