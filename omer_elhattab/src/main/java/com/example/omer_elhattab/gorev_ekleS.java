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

@WebServlet(name = "Gorev_ekle_server", value = "/gorev_ekleS")
public class gorev_ekleS extends HttpServlet {

    private gorev_list gorev_veri=new gorev_list();



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        String Gorev_adi=request.getParameter("gorev_adi");
        String onem_dercesi=request.getParameter("gorev_dercesi");
        String gorev_acıklama=request.getParameter("gorev_acıklama");
        String Gorev_tarihi=request.getParameter("tarih");
        görevler gorev1=new görevler(Gorev_adi,gorev_acıklama,onem_dercesi,Gorev_tarihi);
        gorev_veri.gorevEkle(gorev1);
        response.sendRedirect(request.getContextPath()+"/gorevler-gor");




    }
    public void destroy() {
    }
}