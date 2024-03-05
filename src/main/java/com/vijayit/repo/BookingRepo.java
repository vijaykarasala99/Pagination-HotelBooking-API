package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.BookingEntity;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {

}
