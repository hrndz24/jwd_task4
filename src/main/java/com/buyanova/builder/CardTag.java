package com.buyanova.builder;

public enum CardTag {
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

    CardTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CardTag getByValue(String value) {
        for (CardTag cardTagType : CardTag.values()) {
            if (cardTagType.value.equals(value)) {
                return cardTagType;
            }
        }
        return INVALID_TAG;
    }
}
