import { Component } from '@angular/core';
@Component({
  selector: 'app-payment-perfume',
  templateUrl: './payment-perfume.component.html',
  styleUrl: './payment-perfume.component.css'
})
export class PaymentPerfumeComponent {
  listCart!: any[];
  totalCost: number = 0;

  ngOnInit () {
    this.listCart = JSON.parse(localStorage.getItem('listCart')!);
    this.totalCost = JSON.parse(localStorage.getItem('totalCost')!);
    console.log(this.listCart)
  }

}
