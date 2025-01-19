package daynilgroupcustomerdetail.model;

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

public class GstDetailsModel {

	
	private int id;
	@NotBlank(message = "panNo cannot Empty")
	private String panNo;
	
	
}
