package daynilgroupcustomerdetail.service;

import java.util.List;

import daynilgroupcustomerdetail.model.CustomerModel;

public interface CustomerService {

 
	public CustomerModel saveCustomer(CustomerModel customerModel);
	
	public List<CustomerModel> saveAllCustomer(List<CustomerModel> customerModels);
 	
	public List<CustomerModel>getAllCustomers();
	
	public  CustomerModel getCustomerById(int id);
	
	public CustomerModel getCustomerByName(String name);
	
	public String deleteCustomerById(int id);
	
	public CustomerModel updateCustomer(CustomerModel customerModel);
}
