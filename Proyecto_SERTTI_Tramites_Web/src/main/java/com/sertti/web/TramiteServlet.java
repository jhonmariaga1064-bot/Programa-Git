package com.sertti.web;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tramites")
public class TramiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String radicado = request.getParameter("radicado");
        request.setAttribute("metodoUsado", "GET");
        request.setAttribute("mensaje", "Consulta realizada para el radicado: " + radicado);
        request.setAttribute("numeroRadicado", radicado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String numeroRadicado = request.getParameter("numeroRadicado");
        String placaVehiculo = request.getParameter("placaVehiculo");
        String tipoTramite = request.getParameter("tipoTramite");

        request.setAttribute("metodoUsado", "POST");
        request.setAttribute("mensaje", "Trámite registrado correctamente en el módulo web.");
        request.setAttribute("numeroRadicado", numeroRadicado);
        request.setAttribute("placaVehiculo", placaVehiculo);
        request.setAttribute("tipoTramite", tipoTramite);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
