package perfume.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perfume.dto.MenuDto;
import perfume.entity.ChildMenu;
import perfume.entity.ParentMenu;
import perfume.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;

	public List<MenuDto> listMenu(int role) {
		List<ChildMenu> listAllChild = menuRepository.findChildMenu(role);
		List<ParentMenu> listAllParent = menuRepository.findMenu(role);
		List<MenuDto> listMenuItem = new ArrayList<MenuDto>();
		
		if(!listAllParent.isEmpty() && listAllParent != null) {
			for(ParentMenu parentMenu : listAllParent) {
				MenuDto menuItem = new MenuDto();
				List<ChildMenu> listChild = listAllChild.stream().filter(child -> child.getIdMenu() == parentMenu.getIdMenu()).collect(Collectors.toList());
				
				menuItem.setIdMenu(parentMenu.getIdMenu());
				menuItem.setName(parentMenu.getName());
				menuItem.setListChild(listChild);
				
				listMenuItem.add(menuItem);
			}
		}
		
        return listMenuItem;
    }
}
