package daynilgroupcustomerdetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import daynilgroupcustomerdetail.model.CustomerModel;
import daynilgroupcustomerdetail.service.CustomerService;
import daynilgroupcustomerdetail.validationexception.RequestValidationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@Tag(description = "save, get, getAll, update, delete", name = "CustomerController")
public class CustomerController {

	@Autowired
	private CustomerService customerServiceImpl;
	
	@PostMapping("/saveCustomer")
	@Operation(summary = "saving new customer")
	public  ResponseEntity<CustomerModel> createCustomer(@RequestBody @Valid CustomerModel customerModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new RequestValidationException(getClass().getSimpleName(),bindingResult.getFieldErrors());
		}
		CustomerModel customer = customerServiceImpl.saveCustomer(customerModel);
		return  new ResponseEntity<CustomerModel>(customer,HttpStatus.OK);
		 
	}
	
	@PostMapping("/addAllCustomers")
	@Operation(summary = "get customer")
	public ResponseEntity<List<CustomerModel>>saveAllCustomer(@RequestBody List<CustomerModel> customerModels){
	List<CustomerModel> allCustomer = customerServiceImpl.saveAllCustomer(customerModels);
	return new ResponseEntity<List<CustomerModel>>(allCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	@Operation(summary = "get all customers")
	public ResponseEntity<List<CustomerModel>>getallCustomers(){
	List<CustomerModel> allCustomers = customerServiceImpl.getAllCustomers();
	return new ResponseEntity<List<CustomerModel>>(allCustomers, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{id}")
	@Operation(summary = "get customers with Id")
	public ResponseEntity<CustomerModel> getCustomerById(@PathVariable int id){
		CustomerModel customerById = customerServiceImpl.getCustomerById(id);
		return new ResponseEntity<CustomerModel>(customerById,HttpStatus.OK);
	}
	@
	GetMapping("/getCustomerByName/{name}")
	@Operation(summary = "get customer with name")
	public ResponseEntity<CustomerModel> getCustomerByName(@PathVariable String name){
		CustomerModel customerByName = customerServiceImpl.getCustomerByName(name);
		return new ResponseEntity<CustomerModel>(customerByName,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "delete customer with Id")
	public ResponseEntity<String>deleteCustomerById(@PathVariable int id){
		String customerById = customerServiceImpl.deleteCustomerById(id);
		return new ResponseEntity<String>(customerById,HttpStatus.OK);
	}

	@PatchMapping("/update")
	@Operation(summary = "update customers")
	public ResponseEntity<CustomerModel>updateCustomer(@RequestBody CustomerModel customerModel){
		CustomerModel updatedCustomer = customerServiceImpl.updateCustomer(customerModel);
		return new ResponseEntity<CustomerModel>(updatedCustomer,HttpStatus.OK);
	}
	
}
