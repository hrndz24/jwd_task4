package com.buyanova.constants;

public enum StringConstant {
    CARD_XSD_PATH("cards.xsd");

    private String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
