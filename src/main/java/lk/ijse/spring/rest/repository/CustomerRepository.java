package lk.ijse.spring.rest.repository;

import lk.ijse.spring.rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
