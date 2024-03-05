package com.vijayit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.vijayit.entity.BookingEntity;

public interface BookingService {

	public BookingEntity save(BookingEntity entity);
	
	public List<BookingEntity> getAll();
	
	public  Optional<BookingEntity> getById(Long id);
	 
	public BookingEntity update(Long id, BookingEntity entity);

	public Page<BookingEntity> getBookinsWithPagination(int page, int size);
	
}
