import { Component } from '@angular/core';
import { CarService } from './car.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
})
export class CarComponent {
  car: any = {
    carNumber: '',
    carCategory: '',
    rateHour: 0,
    bookingDetail: {
      pickupPoint: '',
      dropPoint: '',
      pickupDate: '',
      pickupTime: '',
      dropDate: '',
      dropTime: '',
      driver: [{
        name: '',
        mobNumber: '',
        licenceNo: ''
      }]
    }
  };

  carDetails: any;

  constructor(private carService: CarService) {}

  bookCar() {
    this.carService.bookCar(this.car).subscribe(res => {
      alert('Car booked successfully');
    });
  }

  getBookingDetails(carNumber: string) {
    this.carService.getBookingDetails(carNumber).subscribe(res => {
      this.carDetails = res;
    });
  }
}
