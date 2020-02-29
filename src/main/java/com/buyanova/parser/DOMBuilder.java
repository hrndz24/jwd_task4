package com.buyanova.parser;

import com.buyanova.entity.Card;
import com.buyanova.entity.CardType;
import com.buyanova.entity.CardValue;
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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DOMBuilder {
    private Set<Card> cards;
    private DocumentBuilder docBuilder;

    public DOMBuilder() {
        this.cards = new HashSet<Card>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void buildSetCards(String fileName) {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList cards = root.getElementsByTagName("card");
            for (int i = 0; i < cards.getLength(); i++) {
                Element cardElement = (Element) cards.item(i);
                Card card = buildCard(cardElement);
                this.cards.add(card);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Card buildCard(Element cardElement) {
        Card card = new Card();
        card.setId(cardElement.getAttribute("id"));
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


