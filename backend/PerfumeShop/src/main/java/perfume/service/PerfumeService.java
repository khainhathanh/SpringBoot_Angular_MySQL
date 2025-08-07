package perfume.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perfume.dto.PerfumeDto;
import perfume.entity.Carousel;
import perfume.entity.PagePerfume;
import perfume.entity.Perfume;
import perfume.entity.PicturePerfume;
import perfume.entity.SmellPerfume;
import perfume.entity.Smells;
import perfume.entity.Trademark;
import perfume.repository.PerfumeRepository;


@Service
public class PerfumeService {
	
	@Autowired
	private PerfumeRepository perfumeRepository;

	public PagePerfume<PerfumeDto> listAllPerfumes(Integer page, Integer size) {
		PagePerfume<PerfumeDto> pagePerfumeDto = new PagePerfume<>();
		//vị trí bắt đầu lấy trong listPer
		int offset = (page * size) - size ;
		// Lấy tổng per hiện có
		Integer totalPerfume = perfumeRepository.countAllPerfume();
		// Tìm per theo trang
		List<Perfume> perfumeList = perfumeRepository.findPerfume(size, offset);
		// Lấy key idPer của các per đã tìm
		List<Integer> listIdPers = perfumeList.stream().map(Perfume::getIdPerfume).collect(Collectors.toList());
		// lấy tất cả hương dựa theo key của các per vừa tìm
		List<SmellPerfume> listSmellPerfume = perfumeRepository.findOneSmellPerfume(listIdPers);
		// danh sách các hương đầu tiên của từng per
		List<SmellPerfume> listSmellPerfumeFirst = new ArrayList<>();
		for (int idPers : listIdPers) {
			// Chỉ lấy ra hương đầu tiên trong 1 per
			SmellPerfume itemSmellPer = listSmellPerfume.stream().filter(item -> item.getIdPerfume() == idPers)
					.findFirst().orElse(null);
			listSmellPerfumeFirst.add(itemSmellPer);
		}

		// cặp key (idPer, idSmell) của hương đầu tiên ứng với per
		List<Map<String, Integer>> keyListSmellPerfume = new ArrayList<>();
		for (SmellPerfume smellPerfume: listSmellPerfumeFirst) {
			keyListSmellPerfume.add(Map.of("id_perfume", smellPerfume.getIdPerfume(), "id_smell", smellPerfume.getIdSmell()));
		}
		// Tìm hình ảnh theo cặp key (idPer, idSmell) vừa lấy
		List<PicturePerfume> picturePerfume = perfumeRepository.findPicturePerfumeById(keyListSmellPerfume);
		// Tổng page = tổng per / tổng per trên 1 trang
		int totalPage = totalPerfume / perfumeList.size();
		List<PerfumeDto> listPerfumeDto = new ArrayList<>();
		perfumeList.stream().forEach(per -> {
			// lọc các hương đã tìm theo idPer để set vào
			List<SmellPerfume> smellPerfumeList = listSmellPerfumeFirst.stream()
					.filter(smellPer -> per.getIdPerfume() == smellPer.getIdPerfume()).collect(Collectors.toList());
			// lọc các ảnh đã tìm theo idPer để set vào
			List<PicturePerfume> pictureOnePerfume = picturePerfume.stream()
					.filter(smellPer -> per.getIdPerfume() == smellPer.getIdPerfume()).collect(Collectors.toList());
			PerfumeDto perfumeDto = new PerfumeDto();
			perfumeDto.setPerfume(per);
			perfumeDto.setSmellPerfumeList(smellPerfumeList);
			perfumeDto.setPicturePerfumeList(pictureOnePerfume);
			listPerfumeDto.add(perfumeDto);
		});	
		pagePerfumeDto.setListItem(listPerfumeDto);
		pagePerfumeDto.setCurrentPage(page);
		pagePerfumeDto.setTotalPage(totalPage);
        return pagePerfumeDto;
    }
	
	public List<Carousel> listAllCarousel() {
        return perfumeRepository.findAllCarousel();
    }
	
	public PerfumeDto perfumeDetail(Long id) {
		PerfumeDto perfumeDto = new PerfumeDto();
		// Tìm per theo id truyền vào
		Perfume perfume = perfumeRepository.findOnePerfume(id);
		// Tìm thương hiệu của per vừa tìm
		Trademark trademark = perfumeRepository.findOneTradeMark(perfume.getIdTrademark());
		// Tìm tất cả mùi hương của per
		List<SmellPerfume> smellPerfumeList = perfumeRepository.findSmellPerfume(perfume.getIdPerfume());
		// Lấy danh sách key hương 
		List<Integer> idSmellList = smellPerfumeList.stream().map(SmellPerfume::getIdSmell).collect(Collectors.toList());
		// Tìm tên hương theo key trên
		List<Smells> smellList = perfumeRepository.findSmell(idSmellList);
		// cặp key (idPer, idSmell) của hương tương ứng với per
		List<Map<String, Integer>> keyListSmellPerfume = new ArrayList<>();
		for (SmellPerfume smellPerfume: smellPerfumeList) {
			keyListSmellPerfume.add(Map.of("id_perfume", smellPerfume.getIdPerfume(), "id_smell", smellPerfume.getIdSmell()));
		}
		// Tìm hình ảnh theo cặp key (idPer, idSmell) vừa lấy
		List<PicturePerfume> picturePerfume = perfumeRepository.findPicturePerfumeById(keyListSmellPerfume);
		perfumeDto.setTrademark(trademark);
		perfumeDto.setSmells(smellList);
		perfumeDto.setPerfume(perfume);
		perfumeDto.setSmellPerfumeList(smellPerfumeList);
		perfumeDto.setPicturePerfumeList(picturePerfume);
		return perfumeDto;
				
	}
	
	
}
