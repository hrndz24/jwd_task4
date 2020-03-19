package com.buyanova.service;

import com.buyanova.builder.CardXMLBuilder;
import com.buyanova.entity.Card;
import com.buyanova.exception.ServiceException;
import com.buyanova.exception.XMLValidatorException;
import com.buyanova.validator.CardXMLValidator;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public enum CardXMLParserService {

    INSTANCE;

    public List<Card> parseFileToCards(Part filePart, XMLParserType parser) throws ServiceException {
        CardXMLValidator validator = new CardXMLValidator();
        try {
            validator.validate(filePart.getInputStream());
            CardXMLBuilder builder = parser.getBuilder();
            return builder.buildCards(filePart.getInputStream());
        } catch (XMLValidatorException | IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
