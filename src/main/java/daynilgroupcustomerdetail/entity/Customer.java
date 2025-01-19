package daynilgroupcustomerdetail.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
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
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please provide name")
	private String name;
	@NotBlank(message = "please provide mobileNumber")
	private String mobileNo;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private AddressDetails addressDetails;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private GstDetails gstDetails;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private AdditionalDetails additionalDetails;
}
