package com.buyanova.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public class CardXMLValidatorTest {

    private CardXMLValidator cardXMLValidator;
    @Before
    public void init(){
        this.cardXMLValidator = new CardXMLValidator();
    }

    @Test
    public void validateCorrectFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("validCards.xml");
        Assert.assertTrue(cardXMLValidator.validate(url.getPath(), classLoader.getResource("cards.xsd").getPath()));
    }

    @Test
    public void validateIncorrectFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("invalidCards.xml");
        Assert.assertFalse(cardXMLValidator.validate(url.getPath(), classLoader.getResource("cards.xsd").getPath()));
    }
}