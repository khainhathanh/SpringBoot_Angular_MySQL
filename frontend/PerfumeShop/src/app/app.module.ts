import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { MenuComponent } from './component/menu/menu.component';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PerfumesService } from './service/perfumes.service';
import { CommonModule } from '@angular/common';
import { TrangChuComponent } from './component/trang-chu/trang-chu.component';
import { AppRoutingModule } from './app.routes';
import { CartPerfumeComponent } from './component/cart-perfume/cart-perfume.component';
import { DetailPerfumeComponent } from './component/detail-perfume/detail-perfume.component';
import { PaymentPerfumeComponent } from './component/payment-perfume/payment-perfume.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent, 
    MenuComponent,
    FooterComponent ,
    TrangChuComponent,
    CartPerfumeComponent,
    DetailPerfumeComponent,
    PaymentPerfumeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PerfumesService,
  ],
  bootstrap: [
    AppComponent
  ],
})
export class AppModule { }