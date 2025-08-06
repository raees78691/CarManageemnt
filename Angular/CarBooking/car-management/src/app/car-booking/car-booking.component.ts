import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-car-booking',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './car-booking.component.html',
  styleUrls: ['./car-booking.component.css']

})
export class CarBookingComponent {
  carNumber: string = '';
  carCategory: string='';
  carRateHour: string='';
  carPickupPoint: string = '';
  carDropPoint: string='';
  carPickupDate: string=''; 
  carPickupTime: string = '';
  carDropDate: string='';
  carDropTime: string='';
  driverName: string = '';
  mobNumber: string='';
  licenceNo: string='';
  carNumberFetch: string = '';
  
  carDetails: any;
  
  response: any;

  constructor(private http: HttpClient) {}

  bookCar() {
    const carPayload = {
      carNumber: this.carNumber,
      carCategory: this.carCategory,
      rateHour: this.carRateHour,
      bookingDetail: {
		pickupPoint:this.carPickupPoint,
        dropPoint:this.carDropPoint,
        pickupDate: this.carPickupDate,
        pickupTime: this.carPickupTime,
        dropDate: this.carDropDate,
        dropTime: this.carDropTime,
        driver:[
            {
            name:this.driverName,
            mobNumber:this.mobNumber,
            licenceNo:this.licenceNo
            }

        ]
    }
    };

    this.http.post('http://localhost:8080/cars/book', carPayload)
      .subscribe({
        next: (res) => this.response = res,
        error: (err) => console.error('Booking failed', err)
      });
  }
  
/*getCarDetails() {
    const url = `http://localhost:8080/cars/${this.carNumberFetch}`;
    this.http.get(url).subscribe({
      next: (res) => this.carDetails = res,
      error: (err) => console.error('Error fetching car details', err)
    });
  }*/
  
showDetailsSection: boolean = false;

toggleDetailsSection() {
  this.showDetailsSection = !this.showDetailsSection;
}

  
  getCarDetails() {
  if (!this.carNumberFetch || this.carNumberFetch.trim() === '') {
    this.carDetails = null;
    return;
  }

  const url = `http://localhost:8080/cars/${this.carNumberFetch}`;
  this.http.get(url).subscribe({
    next: (res) => this.carDetails = res,
    error: (err) => {
      console.error('Error fetching car details', err);
      this.carDetails = null;
    }
  });
}


}
