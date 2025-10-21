package com.example.RoomBookingSystem.Services;


import com.example.RoomBookingSystem.Models.Bookings;
import com.example.RoomBookingSystem.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Transactional
    public void saveBooking(Bookings bookings){
        bookings.setDate(new Date());
        bookingRepository.save(bookings);
    }



}
