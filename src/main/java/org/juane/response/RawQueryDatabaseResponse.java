package org.juane.response;

import org.juane.response.commons.Meta;
import org.juane.response.commons.Response;

import java.util.List;

public class RawQueryDatabaseResponse extends Response {
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
        private List<RawResult> results;

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

        public List<RawResult> getResults() {
            return results;
        }

        public void setResults(List<RawResult> results) {
            this.results = results;
        }

        public static class RawResult {
            private List<String> columns;
            private List<List<Object>> rows;

            public List<String> getColumns() {
                return columns;
            }

            public void setColumns(List<String> columns) {
                this.columns = columns;
            }

            public List<List<Object>> getRows() {
                return rows;
            }

            public void setRows(List<List<Object>> rows) {
                this.rows = rows;
            }
        }
    }
}
