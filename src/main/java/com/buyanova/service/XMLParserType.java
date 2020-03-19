package com.buyanova.service;

import com.buyanova.builder.CardXMLBuilder;
import com.buyanova.builder.dom.CardDOMBuilder;
import com.buyanova.builder.sax.CardSAXBuilder;
import com.buyanova.builder.stax.CardStAXBuilder;

public enum XMLParserType {
    DOM(new CardDOMBuilder()),
    SAX(new CardSAXBuilder()),
    STAX(new CardStAXBuilder());

    private CardXMLBuilder builder;

    XMLParserType(CardXMLBuilder builder) {
        this.builder = builder;
    }

    public CardXMLBuilder getBuilder() {
        return builder;
    }
}
