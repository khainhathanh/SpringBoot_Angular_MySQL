package perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import perfume.dto.PerfumeDto;
import perfume.entity.Carousel;
import perfume.entity.PagePerfume;
import perfume.service.PerfumeService;

@RestController
public class PerfumeApi {
	
	@Autowired
	private  PerfumeService perfumeService;
	
	@GetMapping("/listAllPerfumes")
    public PagePerfume<PerfumeDto> getAllUsers(@RequestParam(defaultValue = "0", required = false) Integer page,
    		@RequestParam(defaultValue = "10", required = false) Integer size) {
		 return perfumeService.listAllPerfumes(page,size);
    }
	
	@GetMapping("/listAllCarousel")
    public List<Carousel> getAllCarousel() {
        return perfumeService.listAllCarousel();
    }
	
	@GetMapping("/perfumeDetail/{id}")
    public PerfumeDto getDetailPerfume(@PathVariable Long id) {
		 return perfumeService.perfumeDetail(id);
    }
}
