package perfume.dto;

import java.util.List;

import perfume.entity.Perfume;
import perfume.entity.PicturePerfume;
import perfume.entity.SmellPerfume;
import perfume.entity.Smells;

public class PerfumeDto {
	private Perfume perfume;
	private List<Smells> smells;
	private List<SmellPerfume> smellPerfumeList;
	private List<List<PicturePerfume>> picturePerfumeList;	

	public List<List<PicturePerfume>> getPicturePerfumeList() {
		return picturePerfumeList;
	}

	public void setPicturePerfumeList(List<List<PicturePerfume>> picturePerfumeList) {
		this.picturePerfumeList = picturePerfumeList;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	public List<SmellPerfume> getSmellPerfumeList() {
		return smellPerfumeList;
	}

	public void setSmellPerfumeList(List<SmellPerfume> smellPerfumeList) {
		this.smellPerfumeList = smellPerfumeList;
	}

	public List<Smells> getSmells() {
		return smells;
	}

	public void setSmells(List<Smells> smells) {
		this.smells = smells;
	}
	
	
	
}
