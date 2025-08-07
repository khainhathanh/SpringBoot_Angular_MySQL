import { Component, Input } from '@angular/core';
import { PicturePerfume } from '../../entity/PicturePerfume';
import { SmellPerfume } from '../../entity/SmellPerfume';
import { Trademark } from '../../entity/Trademark';

@Component({
  selector: 'app-detail-perfume',
  templateUrl: './detail-perfume.component.html',
  styleUrl: './detail-perfume.component.css'
})
export class DetailPerfumeComponent {
  perfume: any;
  idSmell: number = 1;
  amountPer: number = 1;
  picturePerfume!: PicturePerfume[];
  smellPerfume!: SmellPerfume;
  tradeMark!: Trademark;
  statusPer!: string;
  gender!: string;
  totalRatingArray!: Array<number>;

  ngOnInit() {
    this.perfume = JSON.parse(localStorage.getItem('shareData')!)
    this.totalRatingArray = JSON.parse(localStorage.getItem('totalRatingArray')!)
    this.getSmellPerfume()
    this.tradeMark = this.perfume.trademark
    this.gender = this.perfume.perfume.gender === 1 ? 'Nam' : 'Nữ'
  }

  onSmellChange(event: Event){
    const selectedValue = (event.target as HTMLSelectElement).value;
    this.idSmell = Number(selectedValue)
    this.getSmellPerfume()
  }

  getSmellPerfume() {
    this.picturePerfume = this.perfume.picturePerfumeList.flat().filter(
      (item: any) => item.idPerfume === this.perfume.perfume.idPerfume && item.idSmell === this.idSmell)
    this.smellPerfume = this.perfume.smellPerfumeList.filter(
      (item: any) => item.idSmell === this.idSmell)[0]
    this.statusPer = this.smellPerfume.status === 1 ? 'còn hàng' : 'hết hàng';
  }

  dashQuantity() {
    this.amountPer > 0 ? this.amountPer-- : this.amountPer
  }

  pushQuantity() {
    this.amountPer < this.smellPerfume.amount ? this.amountPer++ : this.amountPer
  }
}
