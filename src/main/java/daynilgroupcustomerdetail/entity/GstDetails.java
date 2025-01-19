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
public class GstDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "g_id")
	private int id;
	@NotBlank(message = "panNo cannot Empty")
	private String panNo;
}
