package com.buyanova.command.implementation;

import com.buyanova.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SAXParserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO: 10.03.2020 magic string
        return "/jsp/result.jsp";
    }
}
