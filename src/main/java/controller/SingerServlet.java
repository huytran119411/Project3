package controller;

import DAO.SingerRepository;
import model.Customer;
import model.Singer;
import service.CustomerServiceImpl;
import service.SingerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "SingerServlet", value = "/Singer")
public class SingerServlet extends HttpServlet {
    private final SingerServiceImpl singerService = new SingerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "detail":
                break;
            case "delete":
                deleteSinger(request, response);
                break;
            case "edit":
                updateSingerById(request, response);
                break;
            default:
                mainPage(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                addSinger(request, response);
                break;
            case "edit":
                editSinger(request, response);
                break;
        }
    }

    private void addSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String singerName = request.getParameter("singer_name");
        String picture = request.getParameter("picture");
        int phoneNumber = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String url = "customer/mainPageUserAdmin.jsp";
        if(!regexChecker("^[A-Za-z0-9._]{6,30}$", username)) {
            url = "customer/signupSinger.jsp";
            username = "Please input again";
        }

        ArrayList<Singer> singerArrayList = singerService.findAll();
        for (Singer singer: singerArrayList) {
            if (singer.getUsername().equals(username)) {
                url = "customer/signupSinger.jsp";
                username = "Username is  already exists!!!";
                break;
            }
        }

        if(!regexChecker("^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", email)) {
            url = "customer/signupSinger.jsp";
            email = "Please input again";
        }

        if(!regexChecker("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", password)) {
            url = "customer/signupSinger.jsp";
            password = "Please input again";
        }

        Singer singer = new Singer(username, password, singerName, picture, phoneNumber, email, address );
        if(!url.equals("customer/signupSinger.jsp")) {
        singerService.add(singer);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        request.setAttribute("singer",singer);
        requestDispatcher.forward(request, response);
    }

    private void displayAllSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Singer> singerArrayList = singerService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/display.jsp");
        request.setAttribute("singerList", singerArrayList);
        requestDispatcher.forward(request, response);
    }

    private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/mainPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        singerService.delete(id);
        response.sendRedirect("/Customer?action=");
    }

    private void updateSingerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Singer singer = singerService.findtById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/editSinger.jsp");
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }

    private void editSinger(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String singerName = request.getParameter("singer_name");
        String picture = request.getParameter("picture");
        int phoneNumber = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Singer singer = singerService.findtById(id);
        singer.setPassword(password);
        singer.setSingerName(singerName);
        singer.setPicture(picture);
        singer.setPhoneNumber(phoneNumber);
        singer.setEmail(email);
        singer.setAddress(address);
        singerService.update(singer);
        response.sendRedirect("customer/mainPageUserSinger.jsp");
    }

    static boolean regexChecker(String theRegex,String str2Check) {
        // You define the regex using pattern
        Pattern regexPattern =
                Pattern.compile(theRegex);
        // Matcher searches a string for a match
        Matcher regexMatcher =
                regexPattern.matcher(str2Check);
        if (regexMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
