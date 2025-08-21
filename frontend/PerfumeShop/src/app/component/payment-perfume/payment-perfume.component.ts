import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UpdatePerfumeModalComponent } from '../popup/update-perfume-modal/update-perfume-modal.component';

@Component({
  selector: 'app-payment-perfume',
  templateUrl: './payment-perfume.component.html',
  styleUrl: './payment-perfume.component.css'
})
export class PaymentPerfumeComponent {
  listCart!: any[];
  totalCost: number = 0;

  constructor (private dialog: MatDialog){}

  ngOnInit () {
    this.listCart = JSON.parse(localStorage.getItem('listCart')!);
    this.totalCost = JSON.parse(localStorage.getItem('totalCost')!);
    console.log(this.listCart)
  }

    openModal(): void {
	  this.dialog.open(UpdatePerfumeModalComponent, {
      width: '600px',
      position: { top: '10px' },   // ép hiển thị từ trên xuống
      panelClass: 'slide-dialog',
      data: { } 
    });
  }
}
