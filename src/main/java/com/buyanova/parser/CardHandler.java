package com.buyanova.parser;

import com.buyanova.entity.Card;
import com.buyanova.entity.CardType;
import com.buyanova.entity.CardValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.DatatypeConverter;
import java.util.*;

public class CardHandler extends DefaultHandler {

    private List<Card> cards;
    private Card current = null;
    private Tag currentEnum = null;
    private EnumSet<Tag> tags;
    private static Logger logger = LogManager.getLogger(CardHandler.class);

    public CardHandler() {
        cards = new ArrayList<>();
        tags = EnumSet.range(Tag.THEME, Tag.VALUE);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (Tag.CARD.getValue().equals(localName)) {
            current = new Card();
            current.setId(attrs.getValue(0));
            current.setAuthor(attrs.getValue(1));
        } else {
            Tag temp = Tag.getByValue(localName);
            if (tags.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Tag.CARD.getValue().equals(localName)) {
            cards.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case THEME:
                    current.setTheme(s);
                    break;
                case TYPE:
                    current.setType(CardType.valueOf(s.toUpperCase()));
                    break;
                case SENDING_DATE:
                    current.setSendingDate(DatatypeConverter.parseDateTime(s).getTime());
                    break;
                case YEAR:
                    current.setYear(Integer.parseInt(s));
                    break;
                case COUNTRY:
                    current.setCountry(s);
                    break;
                case VALUE:
                    current.setValue(CardValue.valueOf(s.toUpperCase()));
                    break;
                default:
                    logger.warn("Unknown element in XML file");
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
