package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.ParentMenu;

@Component
public class MenuRowMapper implements RowMapper<ParentMenu> {

	@Override
	public ParentMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParentMenu menu = new ParentMenu();
		menu.setIdMenu(rs.getInt("id_menu"));
		menu.setName(rs.getString("name"));
        return menu;
	}

}
