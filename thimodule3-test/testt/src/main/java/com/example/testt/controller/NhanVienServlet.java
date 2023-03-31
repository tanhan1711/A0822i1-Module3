package com.example.testt.controller;

import com.example.testt.bean.CongViec;
import com.example.testt.bean.NhanVien;
import com.example.testt.service.CongViecService;
import com.example.testt.service.CongViecServiceImp;
import com.example.testt.service.NhanVienService;
import com.example.testt.service.NhanVienServiceImp;

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
    NhanVienService nhanVienService = new NhanVienServiceImp();
    CongViecService congViecService = new CongViecServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
                    try {
                        showdeleteNhanVien(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            default:
                listNhanVien(request, response);
                break;
        }
    }

    private void showdeleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int manv = Integer.parseInt(request.getParameter("maNhanVien"));
        nhanVienService.deleteUser(manv);

        List<NhanVien> listNhanvien =nhanVienService.findAll();
        request.setAttribute("listNhanVien", listNhanvien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int manv = Integer.parseInt(request.getParameter("maNhanVien"));
        NhanVien existingUser = nhanVienService.selectNhanVien(manv);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("nhanVien", existingUser);
        dispatcher.forward(request, response);
    }

    private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNhanVien = nhanVienService.findAll();
        request.setAttribute("listNhanVien", listNhanVien);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCongViec", congViecService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                   searchBytenCongViec(request, response);
                   break;
        }
    }

    private void searchBytenCongViec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nhanvien = request.getParameter("search_tencongviec");
        List<NhanVien>  congViecList= nhanVienService.findByTenCongViec(nhanvien);
        request.setAttribute("searchtencongviec", congViecList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diachi");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String maCongViec = request.getParameter("maCongViec");
        CongViec congViec = congViecService.findById(maCongViec);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date ngaySinh = null, ngayKetThucLam = null, ngayBatDauLam = null;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            ngayBatDauLam = dateFormat.parse(request.getParameter("ngaybatdau"));
            ngayKetThucLam = dateFormat.parse(request.getParameter("ngayketthuc"));
        } catch (  ParseException e) {
            throw new RuntimeException(e);
        }
        NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec);
        nhanVienService.update(nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String maCongViec = request.getParameter("maCongViec");
        CongViec congViec = congViecService.findById(maCongViec);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date ngaySinh = null, ngayKetThucLam = null, ngayBatDauLam = null;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            ngayBatDauLam = dateFormat.parse(request.getParameter("ngayBatDauLam"));
            ngayKetThucLam = dateFormat.parse(request.getParameter("ngayKetThucLam"));
        } catch (  ParseException e) {
            throw new RuntimeException(e);
        }
        NhanVien nhanVien = new NhanVien( hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec);
        nhanVienService.add(nhanVien);
        response.sendRedirect("/nhanvien?isCreate=true");
    }
}
