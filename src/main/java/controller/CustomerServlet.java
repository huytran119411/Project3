package controller;

import model.Customer;
import model.Singer;
import service.CustomerServiceImpl;
import service.SingerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "CustomerServlet", value = "/Customer")
public class CustomerServlet extends HttpServlet {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final SingerServiceImpl singerService = new SingerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "detail":
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                updateCustomerById(request, response);
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
                addCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "login":
                login(request, response);
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String url = "customer/login.jsp";
        ArrayList<Customer> customerArrayList = customerService.findAll();
        if(!regexChecker("^[A-Za-z0-9._]{6,30}$", username)) {
            url = "customer/signup.jsp";
            username = "Please input again";
        }
        for (Customer customer: customerArrayList) {
            if (customer.getUsername().equals(username)) {
                url = "customer/signup.jsp";
                username = "Username is  already exists!!!";
                break;
            }
        }
        if(!regexChecker("^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", email)) {
            url = "customer/signup.jsp";
            email = "Please input again";
        }
        if(!regexChecker("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", password)) {
            url = "customer/signup.jsp";
            password = "Please input again";
        }
        Customer customer = new Customer(username, password, phone_number, email, address);
        if(!url.equals("customer/signup.jsp")) {
        customerService.add(customer);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        request.setAttribute("customer",customer);
        requestDispatcher.forward(request, response);
    }

    private void displayAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerArrayList = customerService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/display.jsp");
        request.setAttribute("customers", customerArrayList);
        requestDispatcher.forward(request, response);
    }

    private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/mainPage.jsp");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("result","");
        httpSession.setAttribute("name","");
        httpSession.setAttribute("id","");
        httpSession.setAttribute("singerName","");
        httpSession.setAttribute("singerId","");
        requestDispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        response.sendRedirect("/Customer?action=");
    }

    private void updateCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findtById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        requestDispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findtById(id);
        customer.setPassword(password);
        customer.setPhonenumber(phone_number);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.update(customer);
        response.sendRedirect("customer/mainPageUser.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ArrayList<Customer> customerArrayList = customerService.findAll();
        ArrayList<Singer> singerArrayList = singerService.findAll();
        String url = "customer/login.jsp";
        Customer customer1 = null;
        Singer singer1 = null;
        for (Customer customer : customerArrayList) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                url = "customer/mainPageUser.jsp";
                customer1 = customer;
                break;
            }
        }
        for (Singer singer : singerArrayList) {
            if (singer.getUsername().equals(username) && singer.getPassword().equals(password)) {
                url = "customer/mainPageUserSinger.jsp";
                singer1 = singer;
                break;
            }
        }
        if ((Objects.equals(username, "admin")) && (Objects.equals(password, "admin"))) {
            url = "customer/mainPageUserAdmin.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("result", "Tài Khoản Hoặc Mật Khẩu Không Đúng");
        if (url.equals("customer/mainPageUser.jsp")) {
            httpSession.setAttribute("name", customer1.getUsername());
            httpSession.setAttribute("id", customer1.getId());
        }
        if (url.equals("customer/mainPageUserSinger.jsp")) {
            httpSession.setAttribute("singerName", singer1.getSingerName());
            httpSession.setAttribute("singerId", singer1.getId());
        }
        requestDispatcher.forward(request, response);
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
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/mainpage.jsp");
        requestDispatcher.forward(request, response);
    }
}
