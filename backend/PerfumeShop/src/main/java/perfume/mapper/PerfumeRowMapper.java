package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.Perfume;

@Component
public class PerfumeRowMapper implements RowMapper<Perfume>  {

	@Override
    public Perfume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Perfume perfume = new Perfume();
        perfume.setIdPerfume(rs.getInt("id_perfume"));
        perfume.setIdTrademark(rs.getInt("id_trademark"));
        perfume.setName(rs.getString("name"));
        perfume.setDescription(rs.getString("description"));
        perfume.setGender(rs.getInt("gender"));
        perfume.setCapacity(rs.getString("capacity"));
        perfume.setRatingLevel(rs.getInt("rating_level"));
        perfume.setOrigin(rs.getString("origin"));
        
        return perfume;
    }
}
