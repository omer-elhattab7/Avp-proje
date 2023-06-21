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

@WebServlet(name = "gorevlersiil", value = "/gorevler-sil")
public class gorevler_Sil_gor extends HttpServlet {

    private gorev_list gorev_veri=new gorev_list();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        List<görevler> gorevler=gorev_veri.gorevler_list();
        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Gorev_Sil.jsp");
        rs.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        String gorev_adi=request.getParameter("silinecek");
        gorev_veri.gorevSil(gorev_adi);
        List<görevler> gorevler=gorev_veri.gorevler_list();
        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Gorev_Sil.jsp");
        rs.forward(request,response);


    }

    public void destroy() {
    }
}