import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trang-chu',
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  pagePerfume : any;
  listCarousel : any[] = [];
  page : number = 1;
  size : number = 1;

  constructor (private perfumeService : PerfumesService, private router : Router) {}

  ngOnInit () {
    this.getAllPerfume()
    this.getAllCarousels()
  }

  getAllPerfume(){
    this.perfumeService.getAllPerfumes(this.page, this.size).subscribe((data : any[])=>{
      this.pagePerfume = data
      this.pagePerfume.totalPageArray = Array.from({ length: this.pagePerfume.totalPage }, (_, i) => i + 1);
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
      this.router.navigate(['/detail-perfume']);
    })
  }

  getPagePerfume = (page: number) => {
    this.page = page;
    this.getAllPerfume();
  }
}
