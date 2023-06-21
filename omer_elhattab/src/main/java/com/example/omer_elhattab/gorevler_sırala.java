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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "gorevlersırala", value = "/gorevler-sırala")
public class gorevler_sırala extends HttpServlet {

    private gorev_list gorev_veri=new gorev_list();
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        List<görevler> gorevler=gorev_veri.gorevler_list();
        Collections.sort(gorevler, new Comparator<görevler>() {
            @Override
            public int compare(görevler görev1, görevler görev2) {
                return görev2.getGorev_tarihi().compareTo(görev1.getGorev_tarihi());
            }
        });

        request.setAttribute("gorevler",gorevler);
        RequestDispatcher rs=request.getRequestDispatcher("Zamanı_yakın.jsp");
        rs.forward(request,response);




    }

    public void destroy() {
    }
}