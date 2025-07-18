package perfume.entity;

import lombok.Data;

@Data
public class SmellPerfume {
	private int idPerfume;
	private int idSmell;
	private int amount;
	private float cost;
	private int status;
	
}
