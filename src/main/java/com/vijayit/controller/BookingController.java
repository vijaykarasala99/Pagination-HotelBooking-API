package com.vijayit.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijayit.entity.BookingEntity;
import com.vijayit.service.BookingService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/save")
	 public ResponseEntity<BookingEntity> saveBooking(@RequestBody BookingEntity entity) {
	  BookingEntity savedBooking = bookingService.save(entity);
	   return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
	 }
	
	  @GetMapping("/users")
	    public ResponseEntity<Page<BookingEntity>> getBookinsWithPagination(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "4") int size) {
	        Page<BookingEntity> users = bookingService.getBookinsWithPagination(page, size);
	        return ResponseEntity.ok(users);
	    }
	
	    @GetMapping("/getall")
	    public ResponseEntity<List<BookingEntity>> getAllBookings() {
	     List<BookingEntity> bookings = bookingService.getAll();
	     return new ResponseEntity<>(bookings, HttpStatus.OK);
	    }
	   
	    @GetMapping("/{id}")
	    public ResponseEntity<BookingEntity> getBookingById(@PathVariable Long id) {
	        Optional<BookingEntity> booking = bookingService.getById(id);
	        return booking.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<BookingEntity> updateBooking(@PathVariable Long id, @RequestBody BookingEntity entity) {
	        Optional<BookingEntity> existingBooking = bookingService.getById(id);
	        if (existingBooking.isPresent()) {
	            BookingEntity updatedBooking = bookingService.update(id, entity);
	            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}