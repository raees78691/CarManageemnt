import { Component } from '@angular/core';
import { CarBookingComponent } from './car-booking/car-booking.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CarBookingComponent],
  template: `<app-car-booking></app-car-booking>`,
})
export class AppComponent {}
