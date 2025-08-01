package dev.juanes.response;

import dev.juanes.response.commons.Meta;
import dev.juanes.response.commons.Response;

import java.util.List;
import java.util.Map;

public class QueryDatabaseResponse extends Response {
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public static class Result {
        private Boolean success;
        private Meta meta;
        private List<Map<String, Object>> results;

        public Boolean getSuccess() {
            return success;
        }

        public Meta getMeta() {
            return meta;
        }

        public List<Map<String, Object>> getResults() {
            return results;
        }
    }
}
