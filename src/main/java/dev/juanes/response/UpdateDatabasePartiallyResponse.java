package dev.juanes.response;

import dev.juanes.response.commons.Response;
import dev.juanes.response.commons.Result;

public class UpdateDatabasePartiallyResponse extends Response {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
