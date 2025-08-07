package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.Trademark;

@Component
public class TradeMarkMapper implements RowMapper<Trademark> {

	@Override
	public Trademark mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trademark trademark = new Trademark();
		trademark.setIdTrademark(rs.getInt("id_trademark"));
		trademark.setName(rs.getString("name"));
		trademark.setDescription(rs.getString("description"));
		return trademark;
	}

}
