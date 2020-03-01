package com.buyanova.builder;

import com.buyanova.entity.Card;

import java.util.List;

public interface CardXMLBuilder {

    List<Card> buildCards(String filePath);
}
