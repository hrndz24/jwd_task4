package com.buyanova.parser;

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

public class CardDOMBuilder implements XMLParser{
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
    public List<Card> parse(String filePath) {
        List<Card> cards = new ArrayList<>();
        Document document;
        try {
            document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            NodeList xmlCards = root.getElementsByTagName("card");
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
        card.setId(cardElement.getAttribute(Tag.ID.getValue()));
        card.setAuthor(cardElement.getAttribute("author"));
        card.setTheme(getElementTextContent(cardElement, "theme"));
        card.setType(CardType.valueOf(getElementTextContent(cardElement, "type").toUpperCase()));
        Date date = DatatypeConverter.parseDateTime(getElementTextContent(cardElement, "sendingDate")).getTime();
        card.setSendingDate(date);
        card.setCountry(getElementTextContent(cardElement, "country"));
        int year = Integer.parseInt(getElementTextContent(cardElement, "year"));
        card.setYear(year);
        card.setValue(CardValue.valueOf(getElementTextContent(cardElement, "value").toUpperCase()));
        return card;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}


