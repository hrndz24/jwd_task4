package com.buyanova.command;

public enum JSPParameter {

    FILE_PARAMETER("file"), PARSER_PARAMETER("parser"),
    ERROR_PARAMETER("error"), CARDS_ATTRIBUTE("cards");
    private String value;

    JSPParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
