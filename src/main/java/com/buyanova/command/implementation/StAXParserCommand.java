package com.buyanova.command.implementation;

import com.buyanova.builder.stax.CardStAXBuilder;
import com.buyanova.command.Command;
import com.buyanova.command.JSPParameter;
import com.buyanova.command.JSPPath;
import com.buyanova.entity.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StAXParserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Part filePart;
        try {
            filePart = request.getPart(JSPParameter.FILE_PARAMETER.getValue());
            InputStream inputStream = filePart.getInputStream();
            List<Card> cards = new CardStAXBuilder().buildCards(inputStream);
            request.setAttribute(JSPParameter.CARDS_ATTRIBUTE.getValue(), cards);
        } catch (IOException | ServletException e) {
            request.setAttribute(JSPParameter.ERROR_PARAMETER.getValue(), e.getMessage());
            return JSPPath.ERROR_PAGE.getValue();
        }
        return JSPPath.RESULT_PAGE.getValue();
    }
}
