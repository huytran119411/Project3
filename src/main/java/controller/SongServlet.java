package controller;

import model.Song;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/SongServlet")
public class SongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songName = request.getParameter("nameSong");
        String linkSong = request.getParameter("linkSong");
        String avatar = request.getParameter("avatar");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int singerId = Integer.parseInt(request.getParameter("singerId"));
        Song song = new Song(songName,linkSong,avatar,description,price,singerId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
        request.setAttribute("",song);
        requestDispatcher.forward(request,response);
    }
    private void displayAllSong(HttpServletRequest request, HttpServletResponse response){
    }
}
