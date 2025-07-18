package perfume.entity;

import lombok.Data;

@Data
public class Perfume {
	private int idPerfume;
	private int idTrademark;
	private String name;
	private String description;
	private int gender;
	private String capacity;
	private int ratingLevel;

}
