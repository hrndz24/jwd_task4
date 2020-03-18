package com.buyanova.command;

public enum JSPParameter {

    FILE_PARAMETER("file"), PARSER_PARAMETER("parser"),
    ERROR_PARAMETER("error"), CARDS_ATTRIBUTE("cards"),
    COMMAND_PARAMETER("command"), LANGUAGE_ATTRIBUTE("language");
    private String value;

    JSPParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
