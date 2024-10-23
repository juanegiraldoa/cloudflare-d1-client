package org.juane.response;

import org.juane.response.commons.Meta;
import org.juane.response.commons.Response;

import java.util.List;
import java.util.Map;

public class QueryDatabaseResponse extends Response {
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private Boolean success;
        private Meta meta;
        private List<Map<String, Object>> results;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Meta getMeta() {
            return meta;
        }

        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        public List<Map<String, Object>> getResults() {
            return results;
        }

        public void setResults(List<Map<String, Object>> results) {
            this.results = results;
        }
    }
}
