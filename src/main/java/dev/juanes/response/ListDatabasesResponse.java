package dev.juanes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.response.commons.Response;
import dev.juanes.response.commons.Result;
import dev.juanes.response.commons.ResultInfo;

import java.util.List;

public class ListDatabasesResponse extends Response {
    private List<Result> result;
    @JsonProperty("result_info")
    private ResultInfo resultInfo;

    public List<Result> getResult() {
        return result;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }
}
