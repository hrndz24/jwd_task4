package com.buyanova.builder.sax;

import com.buyanova.builder.CardXMLBuilder;
import com.buyanova.entity.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class CardSAXBuilder implements CardXMLBuilder {

    private static Logger logger = LogManager.getLogger(CardSAXBuilder.class);
    private CardHandler cardHandler;
    private XMLReader reader;

    public CardSAXBuilder() {
        cardHandler = new CardHandler();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(cardHandler);
        } catch (SAXException | ParserConfigurationException e) {
            logger.warn(e);
        }
    }

    @Override
    public List<Card> buildCards(String filePath) {
        List<Card> cards;
        try {
            reader.parse(filePath);
        } catch (SAXException | IOException e) {
            logger.warn(e);
        }
        cards = cardHandler.getCards();
        return cards;
    }
}
