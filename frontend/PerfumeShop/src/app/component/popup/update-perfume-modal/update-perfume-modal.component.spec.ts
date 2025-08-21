import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePerfumeModalComponent } from './update-perfume-modal.component';

describe('UpdatePerfumeModalComponent', () => {
  let component: UpdatePerfumeModalComponent;
  let fixture: ComponentFixture<UpdatePerfumeModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatePerfumeModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePerfumeModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
