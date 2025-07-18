import { Component } from '@angular/core';

@Component({
  selector: 'app-detail-perfume',
  templateUrl: './detail-perfume.component.html',
  styleUrl: './detail-perfume.component.css'
})
export class DetailPerfumeComponent {
  perfume: any;
  idSmell: number = 1;
  picturePerfume: any;
  smellPerfume: any;
  constructor (){}

  ngOnInit() {
    this.perfume = JSON.parse(localStorage.getItem('shareData')!)
    this.picturePerfume = this.perfume.picturePerfumeList.flat().filter(
      (item: any) => item.idPerfume === this.perfume.perfume.idPerfume && item.idSmell === this.idSmell)
    this.smellPerfume = this.perfume.smellPerfumeList.filter((item: any) => item.idSmell === this.idSmell)[0]
  }
}

