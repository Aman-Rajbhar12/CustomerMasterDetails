package daynilgroupcustomerdetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daynilgroupcustomerdetail.entity.Customer;
import daynilgroupcustomerdetail.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

public Customer findByName(String name);

}
