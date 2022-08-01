package DAO;

import model.Customer;
import model.Singer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerRepository {
    private MyConnection myConnection = new MyConnection();
    private final String INSERT_SINGER = "insert into singer (username, password,singer_name,picture, phone_number, email, address) value (?,?,?,?,?);";
    private final String UPDATE_SINGER_BY_ID = "update singer set password = ?, singer_name = ? , picture = ?, phone_number = ?,email = ?,address = ? where id = ?;";

    private final String SELECT_ALL_SINGER = "select * from singer;";
    private final String SELECT_SINGER_BY_ID = "select * from singer where id = ?;";
    private final String DELETE_SINGER_BY_ID = "delete from singer where id = ?;";

    public void addSinger(Singer singer) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINGER);
            preparedStatement.setString(1, singer.getUsername());
            preparedStatement.setString(2, singer.getPassword());
            preparedStatement.setString(3, singer.getSingerName());
            preparedStatement.setString(4, singer.getPicture());
            preparedStatement.setString(5, String.valueOf(singer.getPhoneNumber()));
            preparedStatement.setString(6, singer.getEmail());
            preparedStatement.setString(7, singer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Singer> findAll() {
        ArrayList<Singer> singers = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SINGER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String singerName = resultSet.getString("singer_name");
                String picture = resultSet.getString("picture");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Singer singer = new Singer(id,username,password,singerName,picture,phoneNumber,email,address);
                singers.add(singer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return singers;
    }

    public Singer findSingerById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SINGER_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSinger = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String singerName = resultSet.getString("singer_name");
                String picture = resultSet.getString("picture");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                return new Singer(idSinger,username,password,singerName,picture,phoneNumber,email,address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteSingerById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SINGER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSingerById(Singer singer) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SINGER_BY_ID);
            preparedStatement.setString(1, singer.getPassword());
            preparedStatement.setString(2, singer.getSingerName());
            preparedStatement.setString(3, singer.getPicture());
            preparedStatement.setString(4, String.valueOf(singer.getPhoneNumber()));
            preparedStatement.setString(5, singer.getEmail());
            preparedStatement.setString(6, singer.getAddress());
            preparedStatement.setString(7, String.valueOf(singer.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
