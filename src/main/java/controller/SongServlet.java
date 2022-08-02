package controller;

import model.Customer;
import model.Singer;
import model.Song;
import service.CustomerServiceImpl;
import service.SingerServiceImpl;
import service.SongServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

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
            case "playSong":
                playSong(request, response);
                break;
            case "playSongUser":
                playSongUser(request, response);
                break;
            case "playSongSinger":
                playSongSinger(request, response);
                break;
            case "playSongAdmin":
                playSongAdmin(request, response);
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
                addSong(request, response);
                break;
            case "findSong":
            findSong(request, response);
            break;
            case "findSongUser":
                findSongUser(request, response);
                break;
            case "findSongSinger":
                findSongSinger(request, response);
                break;
            case "findSongAdmin":
                findSongAdmin(request, response);
                break;
        }
    }

    private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songName = request.getParameter("songName");
        String linkSong = request.getParameter("linkSong");
        String linkImage = request.getParameter("linkImage");
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = new Song(songName,linkSong,linkImage,id);
        songService.add(song);
        response.sendRedirect("/Song?action=");
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

    private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/mainPageUserSinger.jsp");
        requestDispatcher.forward(request, response);
    }

    private void playSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = songService.findById(id);
        Singer singer = singerService.findById(song.getSingerId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSong.jsp");
        request.setAttribute("song", song);
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }
    private void playSongUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = songService.findById(id);
        Singer singer = singerService.findById(song.getSingerId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSongUser.jsp");
        request.setAttribute("song", song);
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }
    private void playSongSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = songService.findById(id);
        Singer singer = singerService.findById(song.getSingerId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSongSinger.jsp");
        request.setAttribute("song", song);
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }
    private void playSongAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = songService.findById(id);
        Singer singer = singerService.findById(song.getSingerId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSongAdmin.jsp");
        request.setAttribute("song", song);
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }

    private void findSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<Song> songArrayList = songService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/findSong.jsp");
        request.setAttribute("songArrayList", songArrayList);
        requestDispatcher.forward(request, response);
    }

    private void findSongUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<Song> songArrayList = songService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/findSongUser.jsp");
        request.setAttribute("songArrayList", songArrayList);
        requestDispatcher.forward(request, response);
    }

    private void findSongSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<Song> songArrayList = songService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/findSongSinger.jsp");
        request.setAttribute("songArrayList", songArrayList);
        requestDispatcher.forward(request, response);
    }

    private void findSongAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<Song> songArrayList = songService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/findSongAdmin.jsp");
        request.setAttribute("songArrayList", songArrayList);
        requestDispatcher.forward(request, response);
    }
}
