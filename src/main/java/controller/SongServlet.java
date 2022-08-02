package controller;

import model.Customer;
import model.Singer;
import service.CustomerServiceImpl;
import service.SingerServiceImpl;
import service.SongServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "SongServlet", value = "/Song")
public class SongServlet extends HttpServlet {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final SingerServiceImpl singerService = new SingerServiceImpl();

    private final SongServiceImpl songService = new SongServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "tranfer":
                tranferId(request, response);
                break;
            case "edit":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                addSong(request, response);
                break;
        }
    }

    private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));

    }

    private void displayAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerArrayList = customerService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/display.jsp");
        request.setAttribute("customers", customerArrayList);
        requestDispatcher.forward(request, response);
    }

    private void tranferId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/signupSong.jsp");
        request.setAttribute("id", id);
        requestDispatcher.forward(request, response);
    }

}
