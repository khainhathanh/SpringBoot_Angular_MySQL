import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  productAmount: number = 1;
  constructor (private router : Router){}
  getCartPerfume() {
    this.router.navigate(['/cart-perfume'])
  }
}
