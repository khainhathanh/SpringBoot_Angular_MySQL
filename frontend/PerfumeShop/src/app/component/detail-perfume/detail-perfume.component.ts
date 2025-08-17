import { Component, Input } from '@angular/core';
import { PicturePerfume } from '../../entity/PicturePerfume';
import { SmellPerfume } from '../../entity/SmellPerfume';
import { Trademark } from '../../entity/Trademark';
import { Router } from '@angular/router';

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
  listCart: any[] = [];

  constructor (private router : Router){}

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
    this.amountPer > 1 ? this.amountPer-- : this.amountPer
  }

  pushQuantity() {
    this.amountPer < this.smellPerfume.amount ? this.amountPer++ : this.amountPer
  }

  addCart(idPerfume: number, idSmell: number) {
    const cartData = localStorage.getItem('listCart');
    this.listCart = cartData ? JSON.parse(cartData) : [];
    let indexPertoCart = this.listCart?.findIndex(item => item.perfume.idPerfume === idPerfume &&
  item.smellPerfumeList.some((smell:any) => smell.idSmell === idSmell));
    if (indexPertoCart !== undefined && indexPertoCart !== -1) {
      this.listCart[indexPertoCart].quantity = Number(this.listCart[indexPertoCart].quantity) + Number(this.amountPer);
    } else {
      let smellList = this.perfume.smells.filter((item: any) => item.idSmell == idSmell);
      const newPerfume = {
        ...this.perfume, // copy dữ liệu                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
        picturePerfumeList: [...this.picturePerfume],
        smellPerfumeList: [this.smellPerfume],
        smells: [...smellList],
        quantity: this.amountPer
      };
      this.listCart.push(newPerfume)
    }
    localStorage.setItem('listCart', JSON.stringify(this.listCart));
    localStorage.setItem('totalCart', JSON.stringify(this.listCart.length));
  }

  buyNow (idPerfume: number, idSmell: number) {
    this.addCart(idPerfume, idSmell);
    this.router.navigate(['/cart-perfume'])
  }
}
