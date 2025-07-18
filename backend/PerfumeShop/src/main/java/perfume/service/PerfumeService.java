package perfume.service;

import java.util.ArrayList;
import java.util.List;
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
import perfume.repository.PerfumeRepository;


@Service
public class PerfumeService {
	
	@Autowired
	private PerfumeRepository perfumeRepository;

	public PagePerfume<PerfumeDto> listAllPerfumes(Integer page, Integer size) {
		PagePerfume<PerfumeDto> pagePerfumeDto = new PagePerfume<>();
		int offset = (page * size) - size ;
		Integer totalPerfume = perfumeRepository.countAllPerfume();
		List<Perfume> perfumeList = perfumeRepository.findPerfume(size, offset);
		int totalPage = totalPerfume / perfumeList.size();
		List<PerfumeDto> listPerfumeDto = new ArrayList<>();
		List<List<PicturePerfume>> picturePerfume = new ArrayList<>();
		perfumeList.stream().forEach(item -> {
			List<SmellPerfume> smellPerfumeList = perfumeRepository.findOneSmellPerfume(item.getIdPerfume());
			List<PicturePerfume> pictureOnePerfume = perfumeRepository.findPicturePerfumeById(item.getIdPerfume(), smellPerfumeList.get(0).getIdSmell());
			picturePerfume.add(pictureOnePerfume);
			PerfumeDto perfumeDto = new PerfumeDto();
			perfumeDto.setPerfume(item);
			perfumeDto.setSmellPerfumeList(smellPerfumeList);
			perfumeDto.setPicturePerfumeList(picturePerfume);
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
		Perfume perfume = perfumeRepository.findOnePerfume(id);
		List<SmellPerfume> smellPerfumeList = perfumeRepository.findSmellPerfume(perfume.getIdPerfume());
		List<Integer> idSmellList = smellPerfumeList.stream().map(SmellPerfume::getIdSmell).collect(Collectors.toList());
		List<Smells> smellList = perfumeRepository.findSmell(idSmellList);
		List<List<PicturePerfume>> picturePerfume = new ArrayList<>();
		perfumeDto.setSmells(smellList);
		perfumeDto.setPerfume(perfume);
		perfumeDto.setSmellPerfumeList(smellPerfumeList);
		smellPerfumeList.stream().forEach(item -> {
			List<PicturePerfume> pictureOnePerfume = perfumeRepository.findPicturePerfumeById(item.getIdPerfume(), item.getIdSmell());
			picturePerfume.add(pictureOnePerfume);
		});
		perfumeDto.setPicturePerfumeList(picturePerfume);
		return perfumeDto;
				
	}
	
	
}
