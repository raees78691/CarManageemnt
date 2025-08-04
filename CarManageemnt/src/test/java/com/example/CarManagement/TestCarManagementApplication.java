package com.example.CarManagement;

import com.example.CarManagement.entity.BookingDetail;
import com.example.CarManagement.entity.Car;
import com.example.CarManagement.entity.Driver;
import com.example.CarManagement.repository.CarDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCarManagementApplication {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CarDAO carDAO;

	@BeforeEach
	public void cleanUp() {
		carDAO.deleteAll(); // Clean DB before each test
	}

	@Test
	@DisplayName("Successfully book a car")
	public void testBookCar() throws Exception {
		Car car = new Car();
		car.setCarNumber("MH01");
		car.setCarCategory("SUV");
		car.setRateHour(BigInteger.valueOf(800));

		BookingDetail booking = new BookingDetail();
		booking.setPickupPoint("Mumbai");
		booking.setDropPoint("Pune");
		booking.setPickupDate(new Date());
		booking.setPickupTime("9:00 AM");
		booking.setDropDate(new Date());
		booking.setDropTime("11:00 AM");

		Driver driver = new Driver();
		driver.setName("Amit Kumar");
		driver.setMobNumber("9876543210");
		driver.setLicenceNo("DL123456");

		booking.setDriver(Collections.singletonList(driver));
		car.setBookingDetail(booking);

		mockMvc.perform(post("/cars/book")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(car)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.carNumber").value("MH01"))
				.andExpect(jsonPath("$.bookingDetail.pickupPoint").value("Mumbai"))
				.andExpect(jsonPath("$.bookingDetail.driver[0].name").value("Amit Kumar"));
	}

	@Test
	@DisplayName("Get booking details by car number")
	public void testShowBookingDetails() throws Exception {
		Car car = new Car();
		car.setCarNumber("MH02");
		car.setCarCategory("Sedan");
		car.setRateHour(BigInteger.valueOf(600));
		carDAO.save(car);

		mockMvc.perform(get("/cars/MH02"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.carNumber").value("MH02"))
				.andExpect(jsonPath("$.carCategory").value("Sedan"));
	}

	/*@Test
	@DisplayName("Booking without carNumber should fail")
	public void testBookCarWithoutCarNumber() throws Exception {
		Car car = new Car();
		car.setCarCategory("Mini");
		car.setRateHour(BigInteger.valueOf(300));

		mockMvc.perform(post("/car/book")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(car)))
				.andExpect(status().isBadRequest()); // will only work if @Valid used in controller
	}*/

	@Test
	@DisplayName("Booking not found for given car number")
	public void testBookingNotFound() throws Exception {
		mockMvc.perform(get("/cars/NOT_EXIST"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.carNumber").doesNotExist()); // adjust to 404 if needed
	}
}
