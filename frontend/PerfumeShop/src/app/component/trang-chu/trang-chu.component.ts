import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';
import { ActivatedRoute, Router } from '@angular/router';
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
  listCart!: any[];
  listCarousel!: Carousel[];
  totalRatingLevel: number = 5;
  totalRatingArray!: Array<number>;
  pageCurrent : number = 1;
  size : number = 1;
  keyword: string = '';

  constructor (private perfumeService : PerfumesService, private router : Router, private route: ActivatedRoute) {}

  ngOnInit () {
    this.route.queryParams.subscribe(params => {
      this.keyword = params['keyword'] || '';
      this.getPerfumes();
    });
    this.getAllCarousels()
  }

  getPerfumes(){
    this.perfumeService.getPerfumes(this.pageCurrent, this.size, this.keyword).subscribe((data : any)=>{
      this.pagePerfume = data;
      this.pagePerfume.totalPageList = Array.from({ length: this.pagePerfume.totalPage }, (_, i) => i + 1);
      this.totalRatingArray = Array.from({ length: this.totalRatingLevel }, (_, i) => i + 1);
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
    this.getPerfumes();
  }

  getPagePrevious() {
    this.pageCurrent > 1 ? this.pageCurrent-- : this.pageCurrent
    this.getPerfumes();
  }

  getPageNext() {
    this.pageCurrent < this.pagePerfume.totalPage ? this.pageCurrent++ : this.pageCurrent
    this.getPerfumes();
  }

  addCart(idPerfume: number, idSmell: number) {
    let perfume = this.pagePerfume.listItem.filter(item => item.perfume.idPerfume == idPerfume);
    const cartData = localStorage.getItem('listCart');
    this.listCart = cartData ? JSON.parse(cartData) : [];
    let indexPertoCart  = this.listCart?.findIndex(item => item.perfume.idPerfume == idPerfume
      && item.smellPerfumeList[0].idSmell == idSmell);
    if (indexPertoCart !== undefined && indexPertoCart !== -1) {
      this.listCart[indexPertoCart].quantity = this.listCart[indexPertoCart].quantity + 1;
    } else {
      let smellList = perfume[0].smells.filter((item: any) => item.idSmell == idSmell);
      const newPerfume = {
        ...perfume[0], // copy dữ liệu
        smells: [...smellList],
        quantity: 1
      };
      this.listCart.push(newPerfume)
    }
    localStorage.setItem('listCart', JSON.stringify(this.listCart));
    localStorage.setItem('totalCart', JSON.stringify(this.listCart.length));
  }

}