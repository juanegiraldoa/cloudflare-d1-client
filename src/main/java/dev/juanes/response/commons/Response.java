package dev.juanes.response.commons;

import java.util.List;

public class Response {
    private Boolean success;
    private List<Message> messages;
    private List<Message> errors;

    public Boolean isSuccess() {
        return Boolean.TRUE.equals(success);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> getErrors() {
        return errors;
    }
}
