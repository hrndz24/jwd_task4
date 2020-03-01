package com.buyanova.builder;

import com.buyanova.entity.Card;
import com.buyanova.entity.CardType;
import com.buyanova.entity.CardValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class CardDOMBuilder implements CardXMLBuilder {
    private DocumentBuilder documentBuilder;
    private static Logger logger = LogManager.getLogger(CardDOMBuilder.class);

    public CardDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.warn(e);
        }
    }

    @Override
    public List<Card> buildCards(String filePath) {
        List<Card> cards = new ArrayList<>();
        Document document;
        try {
            document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            NodeList xmlCards = root.getElementsByTagName(CardTag.CARD.getValue());
            for (int i = 0; i < xmlCards.getLength(); i++) {
                Element cardElement = (Element) xmlCards.item(i);
                Card card = buildCard(cardElement);
                cards.add(card);
            }
        } catch (IOException | SAXException e) {
            logger.warn(e);
        }
        return cards;
    }

    private Card buildCard(Element cardElement) {
        Card card = new Card();
        card.setId(cardElement.getAttribute(CardTag.ID.getValue()));
        card.setAuthor(cardElement.getAttribute(CardTag.AUTHOR.getValue()));
        card.setTheme(getElementTextContent(cardElement, CardTag.THEME.getValue()));
        card.setType(CardType.valueOf(getElementTextContent(cardElement, CardTag.TYPE.getValue()).toUpperCase()));
        Date date = DatatypeConverter.parseDateTime(getElementTextContent(cardElement, CardTag.SENDING_DATE.getValue())).getTime();
        card.setSendingDate(date);
        card.setCountry(getElementTextContent(cardElement, CardTag.COUNTRY.getValue()));
        int year = Integer.parseInt(getElementTextContent(cardElement, CardTag.YEAR.getValue()));
        card.setYear(year);
        card.setValue(CardValue.valueOf(getElementTextContent(cardElement, CardTag.VALUE.getValue()).toUpperCase()));
        return card;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}


