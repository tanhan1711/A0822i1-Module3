package com.example.exercise.ss10bai1;

import com.example.exercise.ss10bai1.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
  private static   List<Customer> customers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     customers.add(new Customer("Mai Van Hoan","1983-08-20","Ha Noi","/imgs/a.jpg"));
     customers.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang","/imgs/b.jpg"));
     customers.add(new Customer("Nguyen Thai Hoa","1983-08-22","Nam Dinh","/imgs/c.jpg"));
     customers.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay","/imgs/d.jpg"));
     customers.add(new Customer("Nguyen Dinh Thi","1983-08-19","Ha Noi","/imgs/a.jpg"));

     request.setAttribute("customer",customers);
     request.getRequestDispatcher("baitap2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
