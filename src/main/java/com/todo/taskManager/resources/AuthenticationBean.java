package com.todo.taskManager.resources;

import com.todo.taskManager.models.User;

public class AuthenticationBean {

    private String msg;

    public AuthenticationBean(String s) {
        this.msg = s;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {

        return String.format("HelloworldBean [message=%s]", msg);
    }

}
