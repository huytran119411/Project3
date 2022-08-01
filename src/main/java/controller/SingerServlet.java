package controller;

import model.Customer;
import model.Singer;
import service.SingerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.CustomerServlet.regexChecker;

@WebServlet(name = "SingerServlet", value = "/SingerServlet")
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
                displayAllSinger(request, response);
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

    public void addSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameSinger = request.getParameter("usernameSinger");
        String passwordSinger = request.getParameter("passwordSinger");
        String singerName = request.getParameter("singerName");
        int phoneNumberSinger = Integer.parseInt(request.getParameter("phoneNumberSinger"));
        String emailSinger = request.getParameter("emailSinger");
        String addressSinger = request.getParameter("addressSinger");
        String url = "singer/login_test.jsp";
        if(!regexChecker("^[A-Za-z0-9._]{6,30}$", usernameSinger)) {
            url = "singer/signup.jsp";
            usernameSinger = "Please input again";
        }
        if(!regexChecker("^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", emailSinger)) {
            url = "singer/signup.jsp";
            emailSinger = "Please input again";
        }
        if(!regexChecker("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", passwordSinger)) {
            url = "singer/signup.jsp";
            passwordSinger = "Please input again";
        }
        Singer singer = new Singer(usernameSinger, passwordSinger,singerName, phoneNumberSinger, emailSinger, addressSinger);
        if(!url.equals("singer/signup.jsp")) {
            singerService.add(singer);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        request.setAttribute("singer",singer);
        requestDispatcher.forward(request, response);
    }
    private void displayAllSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Singer> singerArrayList = singerService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("singer/display.jsp");
        request.setAttribute("singer", singerArrayList);
        requestDispatcher.forward(request, response);
    }

    private void deleteSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSinger = Integer.parseInt(request.getParameter("idSinger"));
        singerService.delete(idSinger);
        response.sendRedirect("/Singer?action=");
    }

    private void updateSingerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSinger = Integer.parseInt(request.getParameter("idSinger"));
        Singer singer = singerService.findById(idSinger);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("singer/edit.jsp");
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }

    private void editSinger(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idSinger = Integer.parseInt(request.getParameter("idSinger"));
        String passwordSinger = request.getParameter("passwordSinger");
        int phoneNumberSinger = Integer.parseInt(request.getParameter("phoneNumberSinger"));
        String singerName = request.getParameter("singerName");
        String emailSinger = request.getParameter("emailSinger");
        String addressSinger = request.getParameter("addressSinger");
        Singer singer = singerService.findById(idSinger);
        singer.setPasswordSinger(passwordSinger);
        singer.setPhoneNumberSinger(phoneNumberSinger);
        singer.setEmailSinger(emailSinger);
        singer.setAddressSinger(addressSinger);
        singerService.update(singer);
        response.sendRedirect("/Singer?action=");
    }


}
