package com.buyanova.validator;

import com.buyanova.exception.XMLValidatorException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CardXMLValidator {

    private static final String CARD_XSD_PATH = "cards.xsd";

    public void validate(InputStream fileName) throws XMLValidatorException {
        ClassLoader classLoader = getClass().getClassLoader();
        String schemaName = classLoader.getResource(CARD_XSD_PATH).getPath();
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new XMLValidatorException("This xml file does not correspond to the cards xsd schema", e);
        }
    }
}
