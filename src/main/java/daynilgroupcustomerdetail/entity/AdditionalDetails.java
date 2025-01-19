package daynilgroupcustomerdetail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class AdditionalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ad_id")
	private int id;
	@NotBlank(message = "companyName Cannot Empty")
	private String companyName;
	@NotBlank(message = "Email cannot Empty")
	private String email;
	@NotBlank(message = "nativePlace cannot Empty")
	private String nativePlace;
	
}
