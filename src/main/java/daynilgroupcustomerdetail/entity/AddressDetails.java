package daynilgroupcustomerdetail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class AddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "a_id")
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
