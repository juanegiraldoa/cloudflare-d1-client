package dev.juanes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.response.commons.Message;

public class GetDatabaseBookmarkResponse {
    private boolean success;
    private Message[] errors;
    private Message[] messages;
    private Result result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Message[] getErrors() {
        return errors;
    }

    public void setErrors(Message[] errors) {
        this.errors = errors;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private String bookmark;

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }
    }
}
