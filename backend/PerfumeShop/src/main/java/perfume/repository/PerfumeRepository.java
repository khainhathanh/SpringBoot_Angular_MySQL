package perfume.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import perfume.entity.Carousel;
import perfume.entity.Perfume;
import perfume.entity.PicturePerfume;
import perfume.entity.SmellPerfume;
import perfume.entity.Smells;
import perfume.entity.Trademark;
import perfume.mapper.CarouselRowMapper;
import perfume.mapper.PerfumeRowMapper;
import perfume.mapper.PictureMapper;
import perfume.mapper.SmellMapper;
import perfume.mapper.SmellPerfumeRowMapper;
import perfume.mapper.TradeMarkMapper;

@Repository
public class PerfumeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PerfumeRowMapper perfumeRowMapper;
	
	@Autowired
	private CarouselRowMapper carouselRowMapper;
	
	@Autowired
	private PictureMapper pictureMapper;
	
	@Autowired
	private SmellPerfumeRowMapper smellPerfumeRowMapper;
	
	@Autowired
	private SmellMapper smellMapper;
	
	@Autowired
	private TradeMarkMapper tradeMarkRowMapper;
	
	public List<Perfume> findPerfumes (Integer size, Integer offset, String keyWord) {
        String sql = "SELECT * FROM `perfume`.perfumes";
        
        if (keyWord != null && !keyWord.trim().isEmpty()) {
            sql += " WHERE name LIKE '%" + keyWord + "%'";
        }

        sql += " LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, perfumeRowMapper, size, offset);
    }
	
	public Integer countAllPerfume(String keyWord) {
        String sql = "SELECT COUNT(*) FROM `perfume`.perfumes";
        if (keyWord != null && ! keyWord.trim().isEmpty()) {
            sql += " WHERE name LIKE '%" + keyWord + "%'";
        }

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
	
	public List<Carousel> findAllCarousel() {
        String sql = "SELECT * FROM `perfume`.carousel";
        return jdbcTemplate.query(sql, carouselRowMapper);
    }
    
	public List<SmellPerfume> findOneSmellPerfume(List<Integer> listIdPers) {
		String inSql = listIdPers.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "SELECT * FROM perfume.`perfume-smells` WHERE id_perfume IN (" + inSql + ")";
        return jdbcTemplate.query(sql, listIdPers.toArray(), smellPerfumeRowMapper);
    }
	
	public List<SmellPerfume> findSmellPerfume(Integer id_perfume) {
        String sql = "SELECT * FROM perfume.`perfume-smells` WHERE id_perfume = ?";
        return jdbcTemplate.query(sql, smellPerfumeRowMapper, id_perfume);
    }
	
	public List<Smells> findSmell(List<Integer> idSmellList) {
		String placeholders = idSmellList.stream().map(idSmell -> "?").collect(Collectors.joining(","));
        String sql = "SELECT * FROM perfume.smells WHERE id_smell IN ("+ placeholders +")";
        return jdbcTemplate.query(sql, smellMapper, idSmellList.toArray());
    }
	
	public List<Smells> findAllSmell() {
        String sql = "SELECT * FROM perfume.smells";
        return jdbcTemplate.query(sql, smellMapper);
    }
	
    public List<PicturePerfume> findPicturePerfumeById(Integer id_perfume, Integer id_smell) {
        String sql = "SELECT * FROM perfume.picture WHERE id_perfume = ? AND id_smell= ?";
        return jdbcTemplate.query(sql, pictureMapper, id_perfume, id_smell);
    }
    
	public List<PicturePerfume> findPicturePerfumeById(List<Map<String, Integer>> keyList) {
		// Tạo phần tử (?, ?) cho mỗi cặp
		String tupleSql = keyList.stream().map(p -> "(?, ?)").collect(Collectors.joining(", "));
		String sql = "SELECT * FROM perfume.picture WHERE (id_perfume, id_smell) IN (" + tupleSql + ")";
		Object[] params = keyList.stream()
			    .flatMap(p -> Stream.of(p.get("id_perfume"), p.get("id_smell")))
			    .toArray();
        return jdbcTemplate.query(sql, params, pictureMapper);
    }
	
	public Perfume findOnePerfume (Long id) {
        String sql = "SELECT * FROM `perfume`.perfumes WHERE id_perfume = ?";
        return jdbcTemplate.queryForObject(sql, perfumeRowMapper, id);
    }
	
	public Trademark findOneTradeMark (Integer id) {
        String sql = "SELECT * FROM perfume.trademarks where id_trademark = ?";
        return jdbcTemplate.queryForObject(sql, tradeMarkRowMapper, id);
    }
}