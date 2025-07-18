import { Component } from '@angular/core';
import { MenuService } from '../../service/menu.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  listMenu : any[] = []
  role : number = 1;
  constructor (private menuService : MenuService, private router : Router){
    this.getListMenu()
  }

  getListMenu(){
    this.menuService.getListMenus(this.role).subscribe((data : any[])=>{
      this.listMenu = data
    })
  }
}
