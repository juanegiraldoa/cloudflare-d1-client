package org.juane.response;

import com.google.gson.annotations.SerializedName;
import org.juane.response.commons.Response;
import org.juane.response.commons.Result;
import org.juane.response.commons.ResultInfo;

import java.util.List;

public class ListDatabasesResponse extends Response {
    private List<Result> result;
    @SerializedName("result_info")
    private ResultInfo resultInfo;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
}
