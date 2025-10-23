package com.example.RoomBookingSystem.Repositories;


import com.example.RoomBookingSystem.Models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

    @Query("SELECT b FROM Bookings b join fetch b.room order by b.date asc")
    List<Bookings> findAllByOrderByDateAsc();

}
