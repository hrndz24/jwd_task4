package com.buyanova;

import com.buyanova.command.Command;
import com.buyanova.command.CommandEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
@MultipartConfig(maxFileSize = 10240)
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        // TODO: 10.03.2020 magic string

        Command command = CommandEnum.valueOf(request.getParameter("parser").toUpperCase()).getCommand();
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
