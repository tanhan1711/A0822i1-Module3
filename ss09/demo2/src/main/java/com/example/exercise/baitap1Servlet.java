package com.example.exercise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "baitap1Servlet", value = "/baitap1Servlet")
public class baitap1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ProductDescription = request.getParameter("Product Description");
        float Price = Float.parseFloat(request.getParameter("List Price"));
        float Percent = Float.parseFloat(request.getParameter("Discount Percent"));

        float amount = Price-((float) (Price *  Percent * 0.01));
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Percent: " + Percent + "</h1>");
        writer.println("<h1>Amount: " + amount + "</h1>");
        writer.println("</html>");
    }
}
