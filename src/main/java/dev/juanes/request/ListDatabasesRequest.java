package dev.juanes.request;

import java.util.ArrayList;
import java.util.List;

public class ListDatabasesRequest {
    private final String name;
    private final Integer page;
    private final Integer perPage;

    public String getName() {
        return name;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String query() {
        List<String> params = new ArrayList<>();
        if (name != null) params.add("name=" + name);
        if (page != null) params.add("page=" + page);
        if (perPage != null) params.add("per_page=" + perPage);
        return String.join("&", params);
    }

    ListDatabasesRequest(Builder builder) {
        this.name = builder.name;
        this.page = builder.page;
        this.perPage = builder.perPage;
    }

    public static class Builder {
        private String name;
        private Integer page;
        private Integer perPage;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public Builder withPerPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public ListDatabasesRequest build() {
            return new ListDatabasesRequest(this);
        }
    }
}
