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

@WebServlet(name = "gorevguncele", value = "/gorevler-guncele")
public class gorevler_guncele_gor extends HttpServlet {

    private gorev_list gorev_veri=new gorev_list();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        List<görevler> gorevler=gorev_veri.gorevler_list();
        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Gorev_guncle.jsp");
        rs.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
       String guncelncek_adi=request.getParameter("guncelncek_adi");
        //  String gorev_adi=request.getParameter("yeni_gorev_adi");
        String gorev_onem=request.getParameter("gorev_dercesi");
        String Gorev_acıklama=request.getParameter("yeni_gorev_acıklama");
        String yeni_tarih=request.getParameter("yeni_tarih");
        gorev_veri.gorev_guncele(guncelncek_adi,gorev_onem,Gorev_acıklama,yeni_tarih);
        List<görevler> gorevler=gorev_veri.gorevler_list();
        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Gorev_guncle.jsp");
        rs.forward(request,response);




    }

    public void destroy() {
    }
}