package service;

import DAO.CustomerRepository;
import model.Customer;
import model.Song;

import java.util.ArrayList;

public class CustomerServiceImpl implements IService<Customer>{
public final CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public ArrayList<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.updateCustomerById(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public ArrayList<Customer> findByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Customer> findAllById(int id) {
        return null;
    }

    @Override
    public ArrayList<Song> findSongById(int id) {
        return null;
    }
}
