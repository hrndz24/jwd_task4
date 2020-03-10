package com.buyanova.command.implementation;

import com.buyanova.builder.sax.CardSAXBuilder;
import com.buyanova.command.Command;
import com.buyanova.entity.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SAXParserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO: 10.03.2020 magic string

        Part filePart = null; // Retrieves <input type="file" name="file">
        try {
            filePart = request.getPart("file");
            InputStream inputStream = filePart.getInputStream();
            List<Card> cards = new CardSAXBuilder().buildCards(inputStream);
            System.out.println(cards);
            request.setAttribute("cards", cards);
        } catch (IOException | ServletException e) {
            return "/jsp/error.jsp";
        }
        return "/jsp/result.jsp";
    }
}
