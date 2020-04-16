package io.swagger.model;

import java.io.Serializable;

public class Response implements Serializable {

    private Boolean success;
    private String messages;
    private Object data;
    private int code;

    public Response() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Response(Boolean success, String messages, Object data, Integer code) {
        this.success = success;
        this.messages = messages;
        this.data = data;
        this.code = code;
    }

}
