package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SingerServlet", value = "/SingerServlet")
public class SingerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "detail":
                break;
//            case "delete":
//                deleteSinger(request, response);
//                break;
//            case "edit":
//                updateSingerById(request, response);
//                break;
//            default:
//                displaySinger(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void addSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameSinger = request.getParameter("usernameSinger");
        String passwordSinger = request.getParameter("passwordSinger");
        int phoneNumberSinger = Integer.parseInt(request.getParameter("phoneNumberSinger"));
        String emailSinger = request.getParameter("emailSinger");
        String addressSinger = request.getParameter("addressSinger");
    }
}
