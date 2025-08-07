package perfume.dto;

import java.util.List;

import perfume.entity.Perfume;
import perfume.entity.PicturePerfume;
import perfume.entity.SmellPerfume;
import perfume.entity.Smells;
import perfume.entity.Trademark;

public class PerfumeDto {
	private Perfume perfume;
	private List<Smells> smells;
	private Trademark trademark;
	private List<SmellPerfume> smellPerfumeList;
	private List<PicturePerfume> picturePerfumeList;	

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

	public Trademark getTrademark() {
		return trademark;
	}

	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}

	public List<PicturePerfume> getPicturePerfumeList() {
		return picturePerfumeList;
	}

	public void setPicturePerfumeList(List<PicturePerfume> picturePerfumeList) {
		this.picturePerfumeList = picturePerfumeList;
	}
	
	
}
