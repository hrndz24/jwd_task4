package com.buyanova.parser;

public enum Tag {
    // TODO: 01.03.2020 finish
    OLD_CARDS("oldCards"),
    CARD("card"),
    ID("id"),
    AUTHOR("author"),
    THEME("theme"),
    TYPE("type"),
    SENDING_DATE("sendingDate"),
    YEAR("year"),
    COUNTRY("country"),
    VALUE("value"),
    INVALID_TAG("InvalidTag");



    private String value;

    Tag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Tag getByValue(String value) {
        for (Tag tagType : Tag.values()) {
            if (tagType.value.equals(value)) {
                return tagType;
            }
        }
        return INVALID_TAG;
    }
}
