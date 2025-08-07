import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';
import { Router } from '@angular/router';
import { Carousel } from '../../entity/Carousel';
import { Page } from '../../entity/Page';
import { Perfume } from '../../entity/Perfume';

@Component({
  selector: 'app-trang-chu',
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  pagePerfume!: Page;
  listCart: any;
  listCarousel!: Carousel[];
  totalRatingLevel: number = 5;
  totalRatingArray!: Array<number>;
  pageCurrent : number = 1;
  size : number = 1;

  constructor (private perfumeService : PerfumesService, private router : Router) {}

  ngOnInit () {
    this.getAllPerfume()
    this.getAllCarousels()
  }

  getAllPerfume(){
    this.perfumeService.getAllPerfumes(this.pageCurrent, this.size).subscribe((data : any)=>{
      this.pagePerfume = data;
      this.pagePerfume.totalPageList = Array.from({ length: this.pagePerfume.totalPage }, (_, i) => i + 1);
      this.totalRatingArray = Array.from({ length: this.totalRatingLevel }, (_, i) => i + 1);
      // console.log(this.pagePerfume)
    })
  }

  getAllCarousels(){
    this.perfumeService.getAllCarousels().subscribe((data : any[])=>{
      this.listCarousel = data
    })
  }

  getDetailPerfume = (idPerfume: number)  => {
    this.perfumeService.getDetailPerfume(idPerfume).subscribe((data : any[])=>{
      localStorage.setItem('shareData', JSON.stringify(data));
      localStorage.setItem('totalRatingArray', JSON.stringify(this.totalRatingArray));
      this.router.navigate(['/detail-perfume']);
    })
  }

  getPagePerfume = (page: number) => {
    this.pageCurrent = page;
    this.getAllPerfume();
  }

  getPagePrevious() {
    this.pageCurrent > 1 ? this.pageCurrent-- : this.pageCurrent
  }

  getPageNext() {
    this.pageCurrent < this.pagePerfume.totalPage ? this.pageCurrent++ : this.pageCurrent
  }

  addCart(idPerfume: number) {
    let perfume = this.pagePerfume.listItem.filter(item => item.perfume.idPerfume == idPerfume);
    const cartData = localStorage.getItem('listCart');
    this.listCart = cartData === null ? null : JSON.parse(cartData);
    if (this.listCart === null) {
      this.listCart = perfume
      localStorage.setItem('listCart', JSON.stringify(this.listCart));
          console.log(this.listCart)
    } else {
      this.listCart.push(perfume)
      console.log(this.listCart)
    } 
    
  }
}
