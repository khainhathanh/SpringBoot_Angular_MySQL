package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.SmellPerfume;

@Component
public class SmellPerfumeRowMapper implements RowMapper<SmellPerfume>{

	@Override
	public SmellPerfume mapRow(ResultSet rs, int rowNum) throws SQLException {
		SmellPerfume smellPerfume = new SmellPerfume();
		smellPerfume.setAmount(rs.getInt("quantity"));
		smellPerfume.setCost(rs.getFloat("cost"));
		smellPerfume.setIdPerfume(rs.getInt("id_perfume"));
		smellPerfume.setIdSmell(rs.getInt("id_smell"));
		smellPerfume.setStatus(rs.getInt("status"));
		
		return smellPerfume;
	}

}
