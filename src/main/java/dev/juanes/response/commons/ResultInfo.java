package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultInfo {
    private Integer count;
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total_count")
    private Integer totalCount;

    public Integer getCount() {
        return count;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}
