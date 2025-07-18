package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.Smells;

@Component
public class SmellMapper implements RowMapper<Smells> {

	@Override
	public Smells mapRow(ResultSet rs, int rowNum) throws SQLException {
		Smells smell = new Smells();
		smell.setIdSmell(rs.getInt("id_smell"));
		smell.setName(rs.getString("name"));
		return smell;
	}

}
