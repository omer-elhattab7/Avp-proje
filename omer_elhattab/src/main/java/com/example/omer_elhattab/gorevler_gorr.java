package com.example.omer_elhattab;

import date.gorev_list;
import date.görevler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "gorevlergor", value = "/gorevler-gor")
public class gorevler_gorr extends HttpServlet {

    private gorev_list gorev_veri=new gorev_list();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        List<görevler> gorevler=gorev_veri.gorevler_list();
        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Gorev_Listesi.jsp");
        rs.forward(request,response);




    }

    public void destroy() {
    }
}