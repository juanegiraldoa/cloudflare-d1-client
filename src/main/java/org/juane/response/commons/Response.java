package org.juane.response.commons;

import java.util.List;

public class Response {
    private Boolean success;
    private List<Message> messages;
    private List<Message> errors;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getErrors() {
        return errors;
    }

    public void setErrors(List<Message> errors) {
        this.errors = errors;
    }
}
