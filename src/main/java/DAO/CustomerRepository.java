package DAO;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository {
        private MyConnection myConnection = new MyConnection();
        private final String INSERT_CUSTOMER = "insert into customer (username, password, phone_number, email, address) value (?,?,?,?,?);";
        private final String UPDATE_CUSTOMER_BY_ID = "update customer set password = ?, phone_number = ? , email = ?, address = ? where id = ?;";

        private final String SELECT_ALL_CUSTOMER = "select * from customer;";
        private final String SELECT_CUSTOMER_BY_ID = "select * from customer where id = ?;";
        private final String DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?;";

        public void addCustomer(Customer customer) {
            try {
                Connection connection = myConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setString(1, customer.getUsername());
                preparedStatement.setString(2, customer.getPassword());
                preparedStatement.setString(3, String.valueOf(customer.getPhonenumber()));
                preparedStatement.setString(4, customer.getEmail());
                preparedStatement.setString(5, customer.getAddress());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public ArrayList<Customer> findAll() {
            ArrayList<Customer> customers = new ArrayList<>();
            try {
                Connection connection = myConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int phone_number = resultSet.getInt("phone_number");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    Customer customer = new Customer(id, username, password, phone_number, email, address);
                    customers.add(customer);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return customers;
        }

        public Customer findCustomerById(int id) {
            try {
                Connection connection = myConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setString(1, String.valueOf(id));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id_cus = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int phone_number = resultSet.getInt("phone_number");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    return new Customer(id_cus, username, password, phone_number, email, address);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        public void deleteCustomerById(int id) {
            try {
                Connection connection = myConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateCustomerById(Customer customer) {
            try {
                Connection connection = myConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
                preparedStatement.setString(1, customer.getPassword());
                preparedStatement.setString(2, String.valueOf(customer.getPhonenumber()));
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getAddress());
                preparedStatement.setString(5, String.valueOf(customer.getId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
