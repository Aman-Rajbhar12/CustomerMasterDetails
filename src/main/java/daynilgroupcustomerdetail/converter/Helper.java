package daynilgroupcustomerdetail.converter;

import daynilgroupcustomerdetail.entity.AdditionalDetails;
import daynilgroupcustomerdetail.entity.AddressDetails;
import daynilgroupcustomerdetail.entity.Customer;
import daynilgroupcustomerdetail.entity.GstDetails;
import daynilgroupcustomerdetail.model.AdditionalDetailsModel;
import daynilgroupcustomerdetail.model.AddressDetailsModel;
import daynilgroupcustomerdetail.model.CustomerModel;
import daynilgroupcustomerdetail.model.GstDetailsModel;

public class Helper {

	public static Customer prepareCustomer(CustomerModel customerModel) {
		Customer customer = new Customer();
		customer.setId(customerModel.getId());
		customer.setName(customerModel.getName());
		customer.setMobileNo(customerModel.getMobileNo());
//		customer.setAddressDetails(prepareAddressDetails(customerModel.getAddressDetails()));
		customer.setAddressDetails(prepareAddressDetails(customerModel.getAddressDetails()));
		customer.setGstDetails(prepareGstDetails(customerModel.getGstDetails()) );
		customer.setAdditionalDetails(prepareAdditionalDetails(customerModel.getAdditionalDetails()) );
		return customer;
	}
	
	public static AddressDetails prepareAddressDetails(AddressDetailsModel addressDetailsModel) {
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setId(addressDetailsModel.getId());
		addressDetails.setShippingAddress(addressDetailsModel.getShippingAddress());
		addressDetails.setShippingPincode(addressDetailsModel.getShippingPincode());
		addressDetails.setBillingAddress(addressDetailsModel.getBillingAddress());
		addressDetails.setBillingPincode(addressDetailsModel.getBillingPincode());
		return addressDetails;
	}
	
	public static GstDetails prepareGstDetails(GstDetailsModel gstDetailsModel){
		GstDetails gstDetails = new GstDetails();
		gstDetails.setId(gstDetailsModel.getId());
		gstDetails.setPanNo(gstDetailsModel.getPanNo());
		return gstDetails;
	}
	
	public static AdditionalDetails prepareAdditionalDetails(AdditionalDetailsModel additionalDetailsModel) {
		AdditionalDetails additionalDetails = new AdditionalDetails();
		additionalDetails.setId(additionalDetailsModel.getId());
		additionalDetails.setCompanyName(additionalDetailsModel.getCompanyName());
		additionalDetails.setEmail(additionalDetailsModel.getEmail());
		additionalDetails.setNativePlace(additionalDetailsModel.getNativePlace());
		return additionalDetails;
	}
	
	//get
	
	public static CustomerModel prepareCustomerModel(Customer customer) {
		CustomerModel customerModel = new CustomerModel();
		customerModel.setId(customer.getId());
		customerModel.setName(customer.getName());
		customerModel.setMobileNo(customer.getMobileNo());
		customerModel.setAddressDetails(prepareAddressDetailsModel(customer.getAddressDetails()));
		customerModel.setAdditionalDetails(prepareAdditionalDetailsModel(customer.getAdditionalDetails()) );
		customerModel.setGstDetails(prepareGstDetailsModel(customer.getGstDetails()));
		return customerModel;
	}
	
	public static AddressDetailsModel prepareAddressDetailsModel(AddressDetails addressDetail) {
		AddressDetailsModel addressDetailModel = new AddressDetailsModel();
		addressDetailModel.setId(addressDetail.getId());
		addressDetailModel.setBillingAddress(addressDetail.getBillingAddress());
		addressDetailModel.setBillingPincode(addressDetail.getBillingPincode());
		addressDetailModel.setShippingAddress(addressDetail.getShippingAddress());
		addressDetailModel.setShippingPincode(addressDetail.getShippingPincode());
 		return addressDetailModel;
	}
	
	public static GstDetailsModel prepareGstDetailsModel(GstDetails gstDetails){
		GstDetailsModel gstDetailsModel = new GstDetailsModel();
		gstDetailsModel.setId(gstDetails.getId());
		gstDetailsModel.setPanNo(gstDetails.getPanNo());
		return gstDetailsModel;
	}
	
	public static AdditionalDetailsModel prepareAdditionalDetailsModel( AdditionalDetails addtionalDetails) {
		AdditionalDetailsModel additionalDetailsModel = new AdditionalDetailsModel();
		additionalDetailsModel.setId(addtionalDetails.getId());
		additionalDetailsModel.setCompanyName(addtionalDetails.getCompanyName());
		additionalDetailsModel.setEmail(addtionalDetails.getEmail());
		additionalDetailsModel.setNativePlace(addtionalDetails.getNativePlace());
		return additionalDetailsModel;
		}
	
	//update
	
	public static Customer prepareUpdateCustomer(Customer customer , CustomerModel customerModel){
		customer.setId(customerModel.getId());
		customer.setName(customerModel.getName());
		customer.setMobileNo(customerModel.getMobileNo());
		customer.setAdditionalDetails(prepareAdditionalDetails(customerModel.getAdditionalDetails()) );
		customer.setAddressDetails(prepareAddressDetails(customerModel.getAddressDetails()) );
		customer.setGstDetails(prepareGstDetails(customerModel.getGstDetails()) );
		return customer;
}
	
}
