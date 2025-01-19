package daynilgroupcustomerdetail.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerModel {

	private int id;
	@NotBlank(message = "Please provide name")
	private String name;
	@NotBlank(message = "please provide mobileNumber")
	private String mobileNo;
	private AddressDetailsModel addressDetails;
	private GstDetailsModel gstDetails;
	private AdditionalDetailsModel additionalDetails;
	
	

}
