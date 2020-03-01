package com.buyanova.parser;

import com.buyanova.entity.Card;

import java.util.List;

public interface XMLParser {

    List<Card> parse(String filePath);
}
