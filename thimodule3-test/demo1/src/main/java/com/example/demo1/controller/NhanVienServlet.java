package com.example.demo1.controller;

import com.example.demo1.model.Congviec;
import com.example.demo1.model.Nhanvien;
import com.example.demo1.repository.CongviecRepo;
import com.example.demo1.repository.ICongviecRepo;
import com.example.demo1.repository.INhanvienRepo;
import com.example.demo1.repository.NhanvienRepo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = "/nhanvien")
public class NhanVienServlet extends HttpServlet {
       ICongviecRepo iCongviecRepo = new CongviecRepo();
       INhanvienRepo iNhanvienRepo = new NhanvienRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Nhanvien> listNhanvien = iNhanvienRepo.selectAllUsers();
        request.setAttribute("listNhanvien", listNhanvien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertEmployee(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maNhanVien = Integer.parseInt(request.getParameter("manv"));
        String hoTen = request.getParameter("tennv");
        String diaChi = request.getParameter("diachi");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String maCongViec = request.getParameter("macv");
        Congviec congViec = iCongviecRepo.findById(maCongViec);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date ngaySinh = null, ngayKetThucLam = null, ngayBatDauLam = null;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaysinh"));
            ngayBatDauLam = dateFormat.parse(request.getParameter("ngaybatdau"));
            ngayKetThucLam = dateFormat.parse(request.getParameter("ngayketthuc"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Nhanvien nhanvien = new Nhanvien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec);
        iNhanvienRepo.insertUser(nhanvien);
        response.sendRedirect("/nhanvien?isCreate=true");
    }

}

