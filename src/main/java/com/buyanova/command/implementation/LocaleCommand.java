package com.buyanova.command.implementation;

import com.buyanova.command.Command;
import com.buyanova.command.JSPParameter;
import com.buyanova.command.JSPPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(JSPParameter.LANGUAGE_ATTRIBUTE.getValue(),
                request.getParameter(JSPParameter.LANGUAGE_ATTRIBUTE.getValue()));
        return JSPPath.HOME_PAGE.getValue();

    }
}
