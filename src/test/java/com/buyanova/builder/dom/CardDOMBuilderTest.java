package com.buyanova.builder.dom;

import com.buyanova.entity.Card;
import com.buyanova.entity.CardType;
import com.buyanova.entity.CardValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardDOMBuilderTest {

    private CardDOMBuilder cardDOMBuilder;
    private List<Card> validCards;
    private URL url;

    @Before
    public void init() {
        this.cardDOMBuilder = new CardDOMBuilder();
        validCards = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        url = classLoader.getResource("validCards.xml");
        buildValidCards();
    }

    @Test
    public void buildCards() {
        List<Card> actual = cardDOMBuilder.buildCards(url.getPath());
        List<Card> expected = validCards;
        Assert.assertEquals(actual, expected);
    }

    private void buildValidCards() {
        Card card1 = new Card();
        card1.setId("AZ7L-AWE5-DF9H-AS34");
        card1.setAuthor("Mike Hernandez");
        card1.setTheme("Religion");
        card1.setType(CardType.PROMOTIONAL);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, 2019);
        calendar1.set(Calendar.MONTH, 4);
        calendar1.set(Calendar.DAY_OF_MONTH, 30);
        calendar1.set(Calendar.HOUR, 9);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        card1.setSendingDate(calendar1.getTime());
        card1.setYear(2018);
        card1.setCountry("Russia");
        card1.setValue(CardValue.THEMATIC);

        Card card2 = new Card();
        card2.setId("AZ7L-56GE-DF9H-AS34");
        card2.setAuthor("");
        card2.setTheme("Landscape");
        card2.setType(CardType.CONGRATULATORY);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR, 2019);
        calendar2.set(Calendar.MONTH, 3);
        calendar2.set(Calendar.DAY_OF_MONTH, 4);
        calendar2.set(Calendar.HOUR, 9);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);

        card2.setSendingDate(calendar2.getTime());
        card2.setYear(2012);
        card2.setCountry("Costa Rica");
        card2.setValue(CardValue.COLLECTIBLE);

        validCards.add(card1);
        validCards.add(card2);
    }
}