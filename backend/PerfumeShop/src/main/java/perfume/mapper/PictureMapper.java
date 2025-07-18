package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.PicturePerfume;

@Component
public class PictureMapper implements RowMapper<PicturePerfume>{

	@Override
	public PicturePerfume mapRow(ResultSet rs, int rowNum) throws SQLException {
		PicturePerfume picturePerfume = new PicturePerfume();
		picturePerfume.setIdPicture(rs.getInt("id_picture"));
		picturePerfume.setIdPerfume(rs.getInt("id_perfume"));
		picturePerfume.setIdSmell(rs.getInt("id_smell"));
		picturePerfume.setPictureName(rs.getString("picture_name"));
		picturePerfume.setSrc(rs.getString("src"));
		return picturePerfume;
	}

}
