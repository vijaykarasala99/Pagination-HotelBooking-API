package com.vijayit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vijayit.entity.BookingEntity;
import com.vijayit.repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookRepo;

	@Override
	public BookingEntity save(BookingEntity entity) {
		return bookRepo.save(entity);
	}

	@Override
	public List<BookingEntity> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Optional<BookingEntity> getById(Long id) {
		return bookRepo.findById(id);
	}

	@Override
	public BookingEntity update(Long id, BookingEntity entity) {
		Optional<BookingEntity> exisiting = bookRepo.findById(id);
		if (exisiting.isPresent()) {
			BookingEntity bookentity = exisiting.get();
			bookentity.setRoomtype(entity.getRoomtype());
			bookentity.setCheckinDate(entity.getCheckinDate());
			bookentity.setCheckoutDate(entity.getCheckoutDate());
			bookentity.setAdults(entity.getAdults());
			bookentity.setChildren(entity.getChildren());
			bookentity.setNettotal(entity.getNettotal());
			return bookRepo.save(bookentity);

		} else {
			return null;
		}
	}

	@Override
	public Page<BookingEntity> getBookinsWithPagination(int page, int size) {
		  PageRequest pageRequest = PageRequest.of(page, size);
	        return bookRepo.findAll(pageRequest);
	    }
	}
