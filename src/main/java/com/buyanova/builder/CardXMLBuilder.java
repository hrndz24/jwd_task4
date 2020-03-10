package com.buyanova.builder;

import com.buyanova.entity.Card;

import java.io.InputStream;
import java.util.List;

public interface CardXMLBuilder {

    List<Card> buildCards(InputStream filePath);
}
