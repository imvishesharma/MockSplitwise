package com.mock.splitwise.mocksplitwise.model;

import java.util.ArrayList;

public class Response {
    private final ArrayList<String> list = new ArrayList<>();
    private String message;

    public Response(String name) {
        list.add("1");
        list.add("2");
        message = name;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public String getMessage() {
        return message;
    }
}
