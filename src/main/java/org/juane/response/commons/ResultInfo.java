package org.juane.response.commons;

import com.google.gson.annotations.SerializedName;

public class ResultInfo {
    private Integer count;
    private Integer page;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("total_count")
    private Integer totalCount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
