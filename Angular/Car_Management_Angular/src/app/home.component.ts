import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  template: `
    <h1>Welcome to Car Management System</h1>
    <p><a routerLink="/book">Book a car now</a></p>
  `
})
export class HomeComponent {}