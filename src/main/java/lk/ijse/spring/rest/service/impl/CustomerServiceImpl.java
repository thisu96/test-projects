package lk.ijse.spring.rest.service.impl;

import lk.ijse.spring.rest.dto.CustomerDTO;
import lk.ijse.spring.rest.entity.Customer;
import lk.ijse.spring.rest.repository.CustomerRepository;
import lk.ijse.spring.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        ArrayList<CustomerDTO> alCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getUserName(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getContact(),
                    customer.getEmail(),
                    customer.getPassword()
            );

            alCustomers.add(customerDTO);
        }

        return alCustomers;
    }

    @Override
    public CustomerDTO getCustomer(String userName) {
        Customer customer = customerRepository.findById(userName).get();
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getUserName(),
        customer.getCustomerName(),
        customer.getAddress(),
        customer.getContact(),
        customer.getEmail(),
        customer.getPassword());
        return customerDTO;
    }

    @Override
    public boolean deleteCustomer(String userName) {
        customerRepository.deleteById(userName);
        return true;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customer) {
        Customer cust= new Customer(
                customer.getUserName(),
        customer.getCustomerName(),
        customer.getAddress(),
        customer.getContact(),
        customer.getEmail(),
        customer.getPassword());

        customerRepository.save(cust);

        return true;
    }

    @Override
    public boolean canAuthenticate(String username, String password) {
        boolean exists = customerRepository.existsById(username);
        if (!exists){
            return false;
        }
        Customer cust = customerRepository.findById(username).get();
        return cust.getPassword().equals(password);

    }

}
