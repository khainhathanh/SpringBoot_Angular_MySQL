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
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UpdatePerfumeModalComponent } from './component/popup/update-perfume-modal/update-perfume-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent, 
    MenuComponent,
    FooterComponent ,
    TrangChuComponent,
    CartPerfumeComponent,
    DetailPerfumeComponent,
    PaymentPerfumeComponent,
    UpdatePerfumeModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule
  ],
  providers: [
    PerfumesService,
    provideAnimationsAsync(),
  ],
  bootstrap: [
    AppComponent
  ],
})
export class AppModule { }