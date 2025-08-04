import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private baseUrl = 'http://localhost:8080/cars';

  constructor(private http: HttpClient) {}

  bookCar(car: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/book`, car);
  }

  getBookingDetails(carNumber: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${carNumber}`);
  }
}
