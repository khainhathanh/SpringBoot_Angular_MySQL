package perfume.entity;

import lombok.Data;

@Data
public class PicturePerfume {
	private int idPicture;
	private int idPerfume;
	private int idSmell;
	private String pictureName;
	private String src;

}
