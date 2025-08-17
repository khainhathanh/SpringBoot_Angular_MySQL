import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PerfumesService } from '../../service/perfumes.service';
import { Page } from '../../entity/Page';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  pagePerfume!: Page;
  pageCurrent : number = 1;
  size : number = 1;
  productAmount: any;
  keyWord! : string;
  constructor (private perfumeService : PerfumesService, private router : Router){}
   
  ngDoCheck() {
   this.productAmount = localStorage.getItem('totalCart');
  }
  
  getCartPerfume() {
   this.router.navigate(['/cart-perfume'])
  }

  searchPerfume() {
    this.router.navigate(['/perfume'], { queryParams: { keyword: this.keyWord } });
  }
}
