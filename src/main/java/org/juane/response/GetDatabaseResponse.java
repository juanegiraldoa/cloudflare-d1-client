package org.juane.response;

import org.juane.response.commons.Response;
import org.juane.response.commons.Result;

public class GetDatabaseResponse extends Response {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
