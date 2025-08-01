package dev.juanes.response;

import dev.juanes.response.commons.Meta;
import dev.juanes.response.commons.Response;

import java.util.List;

public class RawQueryDatabaseResponse extends Response {
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public static class Result {
        private Boolean success;
        private Meta meta;
        private RawResult results;

        public Boolean getSuccess() {
            return success;
        }

        public Meta getMeta() {
            return meta;
        }

        public RawResult getResults() {
            return results;
        }

        public static class RawResult {
            private List<String> columns;
            private List<List<Object>> rows;

            public List<String> getColumns() {
                return columns;
            }

            public List<List<Object>> getRows() {
                return rows;
            }
        }
    }
}
