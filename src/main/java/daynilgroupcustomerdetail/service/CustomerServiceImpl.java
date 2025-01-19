package daynilgroupcustomerdetail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daynilgroupcustomerdetail.converter.Helper;
import daynilgroupcustomerdetail.entity.Customer;
import daynilgroupcustomerdetail.globalexception.DataNotFoundInDatabase;
import daynilgroupcustomerdetail.globalexception.IdNotFoundException;
import daynilgroupcustomerdetail.globalexception.NameNotFound;
import daynilgroupcustomerdetail.model.CustomerModel;
import daynilgroupcustomerdetail.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerModel saveCustomer(CustomerModel customerModel) {
		Customer customer = Helper.prepareCustomer(customerModel);
		Customer saveCustomers = customerRepository.save(customer);
		return Helper.prepareCustomerModel(saveCustomers);
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		List<Customer> allData = customerRepository.findAll();
		if(allData.isEmpty()) {
			throw new DataNotFoundInDatabase();
		}
		List<CustomerModel> responseData = new ArrayList<CustomerModel>();
		for(Customer customer:allData) {
			responseData.add(Helper.prepareCustomerModel(customer));
		}
		return responseData;
	}
		

	@Override
	public List<CustomerModel> saveAllCustomer(List<CustomerModel> customerModels) {
		 List<Customer> allData = new ArrayList<Customer>();
		 for(CustomerModel customermodel:customerModels) {
			 allData.add(Helper.prepareCustomer(customermodel));
		 }
		 List<Customer>saveAllCustomer = customerRepository.saveAll(allData);
		 List<CustomerModel> getAllData = new ArrayList<CustomerModel>();
		 for(Customer customer:saveAllCustomer) {
			 getAllData.add(Helper.prepareCustomerModel(customer));
		 }
		 return getAllData;
	}

	@Override
	public  CustomerModel getCustomerById(int id) {
		Customer customerById = customerRepository.findById(id).orElse(null);
		if(customerById==null) {
			throw new IdNotFoundException();
		}
		return Helper.prepareCustomerModel(customerById);
	}

	@Override
	public String deleteCustomerById(int id) {
		 Customer cutomerById = customerRepository.findById(id).orElse(null);
		 customerRepository.deleteById(cutomerById.getId());
		return "id:" + id+ ": deleted Successfully";
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customerModel) {
		Customer existingCustomer = customerRepository.findById(customerModel.getId()).orElse(null);
		Customer updatecustomer = Helper.prepareUpdateCustomer(existingCustomer, customerModel);
		Customer saveCustomer = customerRepository.save(updatecustomer);
		CustomerModel updatedCustomer  = Helper.prepareCustomerModel(saveCustomer);
		return updatedCustomer;
	}

	@Override
	public CustomerModel getCustomerByName(String name) {
		 Customer customerName = customerRepository.findByName(name);
		 if(customerName==null) {
			 throw new NameNotFound();
		 }
		 
		return Helper.prepareCustomerModel(customerName);
	}
		 


	
		
		

	 
		
	


}
