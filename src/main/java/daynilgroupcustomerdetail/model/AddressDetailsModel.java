package daynilgroupcustomerdetail.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDetailsModel {

	
	private int id;
	@NotBlank(message = "billingAddress cannot Empty")
	private String billingAddress;
	@NotNull(message = "billingPincode cannot Empty")
	private int billingPincode;
	@NotBlank(message = "shippingAddress cannot Empty")
	private String shippingAddress;
	@NotNull(message = "shippingPincode cannot Empty")
	private int shippingPincode;
}


