package com.buyanova.validator;

import com.buyanova.exception.XMLValidatorException;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class CardXMLValidatorTest {

    private CardXMLValidator cardXMLValidator;

    @Before
    public void init() {
        this.cardXMLValidator = new CardXMLValidator();
    }

    @Test
    public void validateCorrectFile() throws XMLValidatorException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("validCards.xml");
        cardXMLValidator.validate(inputStream);
    }

    @Test(expected = XMLValidatorException.class)
    public void validateIncorrectFile() throws XMLValidatorException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("invalidCards.xml");
        cardXMLValidator.validate(inputStream);
    }
}