import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-update-perfume-modal',
  templateUrl: './update-perfume-modal.component.html',
  styleUrl: './update-perfume-modal.component.css'
})
export class UpdatePerfumeModalComponent {
  constructor(public dialogRef: MatDialogRef<UpdatePerfumeModalComponent>) {}

  closeModal(): void {
	this.dialogRef.close();
  }
}
