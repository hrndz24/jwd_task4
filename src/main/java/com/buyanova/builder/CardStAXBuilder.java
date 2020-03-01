package com.buyanova.builder;

import com.buyanova.entity.Card;
import com.buyanova.entity.CardType;
import com.buyanova.entity.CardValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardStAXBuilder implements CardXMLBuilder {

    private XMLInputFactory inputFactory;
    private static Logger logger = LogManager.getLogger(CardStAXBuilder.class);

    public CardStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public List<Card> buildCards(String filePath) {
        List<Card> cards = new ArrayList<>();
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CardTag.getByValue(name) == CardTag.CARD) {
                        Card card = buildCard(reader);
                        cards.add(card);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            logger.warn(e);
        }
        return cards;
    }

    private Card buildCard(XMLStreamReader reader) throws XMLStreamException {
        Card card = new Card();
        card.setId(reader.getAttributeValue(null, CardTag.ID.getValue()));
        card.setAuthor(reader.getAttributeValue(null, CardTag.AUTHOR.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CardTag.getByValue(name)) {
                        case THEME:
                            card.setTheme(getXMLText(reader));
                            break;
                        case TYPE:
                            card.setType(CardType.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case SENDING_DATE:
                            card.setSendingDate(DatatypeConverter.parseDateTime(getXMLText(reader)).getTime());
                            break;
                        case YEAR:
                            card.setYear(Integer.parseInt(getXMLText(reader)));
                            break;
                        case COUNTRY:
                            card.setCountry(getXMLText(reader));
                            break;
                        case VALUE:
                            card.setValue(CardValue.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CardTag.getByValue(name) == CardTag.CARD) {
                        return card;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Card");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
