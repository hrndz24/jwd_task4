package com.buyanova.command;

public enum JSPPath {

    HOME_PAGE("/index.jsp"), ERROR_PAGE("/jsp/error.jsp"), RESULT_PAGE("/jsp/result.jsp") ;

    private String value;

    JSPPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
