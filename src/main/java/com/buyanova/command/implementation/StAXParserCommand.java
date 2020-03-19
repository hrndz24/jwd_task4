package com.buyanova.command.implementation;

import com.buyanova.command.Command;
import com.buyanova.command.JSPParameter;
import com.buyanova.command.JSPPath;
import com.buyanova.entity.Card;
import com.buyanova.exception.ServiceException;
import com.buyanova.service.CardXMLParserService;
import com.buyanova.service.XMLParserType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class StAXParserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Part filePart;
        try {
            filePart = request.getPart(JSPParameter.FILE_PARAMETER.getValue());
            List<Card> cards = CardXMLParserService.INSTANCE.parseFileToCards(filePart, XMLParserType.STAX);
            request.setAttribute(JSPParameter.CARDS_ATTRIBUTE.getValue(), cards);
        } catch (IOException | ServletException | ServiceException e) {
            request.setAttribute(JSPParameter.ERROR_PARAMETER.getValue(), e.getMessage());
            return JSPPath.ERROR_PAGE.getValue();
        }
        return JSPPath.RESULT_PAGE.getValue();
    }
}
