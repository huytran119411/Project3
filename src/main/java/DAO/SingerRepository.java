package DAO;

import model.Singer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerRepository {
    private MyConnection myConnection = new MyConnection();
    private final String INSERT_SINGER = "insert into singer (usernameSinger, passwordSinger, phoneNumberSinger, singerName, emailSinger, addressSinger) value (?,?,?,?,?,?);";
    private final String SELECT_ALL_SINGER = " select * from singer;";
    private final String SELECT_SINGER_BY_ID = "select * from  singer where id = ?;";
    private final String DELETE_SINGER_BY_ID = "delete from singer where id = ?;";
    private final String UPDATE_SINGER_BY_ID = "update customer set password = ?, phone_number = ? , email = ?, address = ? where id = ?;";

    public void addSinger(Singer singer) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINGER);
            preparedStatement.setString(1, singer.getUsernameSinger());
            preparedStatement.setString(2, singer.getPasswordSinger());
            preparedStatement.setString(3, String.valueOf(singer.getPhoneNumberSinger()));
            preparedStatement.setString(4, singer.getSingerName());
            preparedStatement.setString(5, singer.getEmailSinger());
            preparedStatement.setString(6, singer.getAddressSinger());
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
                int idSinger = resultSet.getInt("idSinger");
                String usernameSinger = resultSet.getString("usernameSinger");
                String passwordSinger = resultSet.getString("passwordSinger");
                String nameSinger = resultSet.getString("nameSinger");
                int phoneNumberSinger = resultSet.getInt("phoneNumberSinger");
                String emailSinger = resultSet.getString("emailSinger");
                String addressSinger = resultSet.getString("addressSinger");
                Singer singer = new Singer(idSinger, usernameSinger, passwordSinger, nameSinger, phoneNumberSinger, emailSinger, addressSinger);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return singers;
    }

    public Singer findSingerById(int idSinger) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SINGER_BY_ID);
            preparedStatement.setString(1, String.valueOf(idSinger));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSing = resultSet.getInt("idSinger");
                String usernameSinger = resultSet.getString("usernameSinger");
                String passwordSinger = resultSet.getString("passwordSinger");
                String singerName = resultSet.getString("singerName");
                int phoneNumberSinger = resultSet.getInt("phoneNumberSinger");
                String emailSinger = resultSet.getString("emailSinger");
                String addressSinger = resultSet.getString("addressSinger");
                return new Singer(idSing, usernameSinger, passwordSinger, singerName, phoneNumberSinger, emailSinger, addressSinger);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteSingerById(int idSinger) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SINGER_BY_ID);
            preparedStatement.setInt(1, idSinger);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSingerById(Singer singer) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SINGER_BY_ID);
            preparedStatement.setString(1, singer.getPasswordSinger());
            preparedStatement.setString(2, String.valueOf(singer.getPasswordSinger()));
            preparedStatement.setString(3, singer.getEmailSinger());
            preparedStatement.setString(4, singer.getAddressSinger());
            preparedStatement.setString(5, String.valueOf(singer.getIdSinger()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}