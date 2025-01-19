package daynilgroupcustomerdetail.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdditionalDetailsModel {


	private int id;
	@NotBlank(message = "companyName Cannot Empty")
	private String companyName;
	@NotBlank(message = "Email cannot Empty")
	private String email;
	@NotBlank(message = "membershipNo cannot Empty")
	private String nativePlace;
	
	
	
	
}
