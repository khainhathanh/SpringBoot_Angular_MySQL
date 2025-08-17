import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart-perfume',
  templateUrl: './cart-perfume.component.html',
  styleUrl: './cart-perfume.component.css'
})
export class CartPerfumeComponent {
  listCart!: any[];
  totalCost: number = 0;
  totalCart: any;

  constructor (private router : Router) {}

  ngOnInit () {
    this.listCart = JSON.parse(localStorage.getItem('listCart')!);
  }

  ngDoCheck () {
    this.totalCost = this.listCart.reduce((sum, item) => {
    // Tính giá cho từng sản phẩm
    let itemCost = item.smellPerfumeList[0].cost * item.quantity;
    // Gán giá này vào item (nếu muốn lưu lại)
    item.totalItemCost = itemCost;
    // Cộng vào tổng
    return sum + itemCost;
    }, 0);
  }

  payMent () {
    localStorage.setItem('listCart', JSON.stringify(this.listCart));
    localStorage.setItem('totalCost', JSON.stringify(this.totalCost));
    this.router.navigate(['/payment-perfume'])
  }

  removePerfume (index : number) {
    // Xoá 1 phần tử tại vị trí index
    this.listCart.splice(index, 1);
    if (this.listCart.length > 0) {
      // Nếu bạn có lưu localStorage thì update luôn
      localStorage.setItem('listCart', JSON.stringify(this.listCart));
      localStorage.setItem('totalCart', JSON.stringify(this.listCart.length));
    } else {
      localStorage.removeItem('listCart');
      localStorage.removeItem('totalCart');
    }
  }
}
