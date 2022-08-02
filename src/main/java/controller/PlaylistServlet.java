package controller;

import model.Customer;
import model.Playlist;
import model.Singer;
import model.Song;
import service.CustomerServiceImpl;
import service.PlaylistServiceImpl;
import service.SingerServiceImpl;
import service.SongServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PlaylistServlet", value = "/Playlist")
public class PlaylistServlet extends HttpServlet {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final SingerServiceImpl singerService = new SingerServiceImpl();
    private final SongServiceImpl songService = new SongServiceImpl();
    private final PlaylistServiceImpl playlistService = new PlaylistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addPlaylist(request, response);
                break;
            case "addFromSearch":
                addPlaylistFromSearch(request, response);
                break;
            case "displaySong":
                displaySongById(request, response);
                break;
            case "play":
                playSongUserPlaylist(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":

                break;
            case "findSong":

                break;
        }
    }
    private void addPlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlistName = request.getParameter("username");
        int songId = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Playlist playlist = new Playlist(playlistName,songId,customerId);
        playlistService.add(playlist);
        response.sendRedirect("customer/mainPageUser.jsp");
    }
    private void addPlaylistFromSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlistName = request.getParameter("username");
        int songId = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Playlist playlist = new Playlist(playlistName,songId,customerId);
        playlistService.add(playlist);
        request.getRequestDispatcher("customer/findSongUser.jsp").forward(request, response);
    }

    private void displaySongById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Song> songArrayList = playlistService.findSongById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSongUserPlaylist.jsp");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("songArrayList", songArrayList);
        request.setAttribute("song",songArrayList.get(1));
        requestDispatcher.forward(request, response);
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        playlistService.delete(id);
        response.sendRedirect("/Customer?action=");
    }
    private void playSongUserPlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Song song = songService.findById(id);
        Singer singer = singerService.findById(song.getSingerId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/playSongUserPlaylist.jsp");
        request.setAttribute("song", song);
        request.setAttribute("singer", singer);
        requestDispatcher.forward(request, response);
    }
}
