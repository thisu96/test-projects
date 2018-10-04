package lk.ijse.spring.rest.service;

import lk.ijse.spring.rest.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(String userName);

    public boolean deleteCustomer(String userName);

    public boolean saveCustomer(CustomerDTO customer);

    public boolean canAuthenticate(String username, String password);
}
