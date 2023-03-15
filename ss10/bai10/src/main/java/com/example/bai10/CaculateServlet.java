package com.example.bai10;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculateServlet", value = "/CaculateServlet")
public class CaculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float so1 = Float.parseFloat(request.getParameter("n1"));
        String operator= request.getParameter("operator");
        float so2 = Float.parseFloat(request.getParameter("n2"));
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>result: " + caculate(so1, operator, so2) +  "</h1>");
        writer.println("</html>");
    }
    private Double caculate(float so1, String operator, float so2) {
        double res= 0;
        switch (operator){
            case "Addition":
                res= so1+ so2;
                break;
            case "Subtraction":
                res= so1- so2;
                break;
            case "Multiplication":
                res= so1* so2;
                break;
            case "Division":
                res = so1/so2;
                break;
        }
        return res;
    }
}
