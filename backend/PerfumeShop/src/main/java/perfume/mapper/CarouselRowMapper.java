package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.Carousel;

@Component
public class CarouselRowMapper implements RowMapper<Carousel> {

	@Override
	public Carousel mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Carousel carousel = new Carousel();
		 	carousel.setIdCarousel(rs.getInt("id_carousel"));
		 	carousel.setImg(rs.getString("img"));
		 	carousel.setAlt(rs.getString("alt"));
		 	carousel.setActive(rs.getInt("active"));
	        return carousel;
	}

}
