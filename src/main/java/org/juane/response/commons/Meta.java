package org.juane.response.commons;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("served_by")
    private String servedBy;
    private Double duration;
    private Integer changes;
    @SerializedName("last_row_id")
    private Integer lastRowId;
    @SerializedName("changed_db")
    private Boolean changedDb;
    @SerializedName("size_after")
    private Integer sizeAfter;
    @SerializedName("rows_read")
    private Integer rowsRead;
    @SerializedName("rows_written")
    private Integer rowsWritten;

    public String getServedBy() {
        return servedBy;
    }

    public void setServedBy(String servedBy) {
        this.servedBy = servedBy;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getChanges() {
        return changes;
    }

    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    public Integer getLastRowId() {
        return lastRowId;
    }

    public void setLastRowId(Integer lastRowId) {
        this.lastRowId = lastRowId;
    }

    public Boolean getChangedDb() {
        return changedDb;
    }

    public void setChangedDb(Boolean changedDb) {
        this.changedDb = changedDb;
    }

    public Integer getSizeAfter() {
        return sizeAfter;
    }

    public void setSizeAfter(Integer sizeAfter) {
        this.sizeAfter = sizeAfter;
    }

    public Integer getRowsRead() {
        return rowsRead;
    }

    public void setRowsRead(Integer rowsRead) {
        this.rowsRead = rowsRead;
    }

    public Integer getRowsWritten() {
        return rowsWritten;
    }

    public void setRowsWritten(Integer rowsWritten) {
        this.rowsWritten = rowsWritten;
    }
}
