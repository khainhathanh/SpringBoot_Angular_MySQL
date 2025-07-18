package perfume.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import perfume.entity.Carousel;
import perfume.entity.Perfume;
import perfume.entity.PicturePerfume;
import perfume.entity.SmellPerfume;
import perfume.entity.Smells;
import perfume.mapper.CarouselRowMapper;
import perfume.mapper.PerfumeRowMapper;
import perfume.mapper.PictureMapper;
import perfume.mapper.SmellMapper;
import perfume.mapper.SmellPerfumeRowMapper;

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
	
	public List<Perfume> findPerfume (Integer size, Integer offset) {
        String sql = "SELECT * FROM `perfume`.perfumes LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, perfumeRowMapper, size, offset);
    }
	
	public Integer countAllPerfume() {
        String sql = "SELECT COUNT(*) FROM `perfume`.perfumes";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
	
	public List<Carousel> findAllCarousel() {
        String sql = "SELECT * FROM `perfume`.carousel";
        return jdbcTemplate.query(sql, carouselRowMapper);
    }
	
	public List<SmellPerfume> findOneSmellPerfume(Integer id_perfume) {
        String sql = "SELECT * FROM perfume.`perfume-smells` WHERE id_perfume = ? LIMIT 1";
        return jdbcTemplate.query(sql, smellPerfumeRowMapper, id_perfume);
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
	
	public List<PicturePerfume> findPicturePerfumeById(Integer id_perfume, Integer id_smell) {
		String sql = "SELECT * FROM perfume.picture WHERE id_perfume = ? AND id_smell= ?";
        return jdbcTemplate.query(sql, pictureMapper, id_perfume, id_smell);
    }
	
	public Perfume findOnePerfume (Long id) {
        String sql = "SELECT * FROM `perfume`.perfumes WHERE id_perfume = ?";
        return jdbcTemplate.queryForObject(sql, perfumeRowMapper, id);
    }
}