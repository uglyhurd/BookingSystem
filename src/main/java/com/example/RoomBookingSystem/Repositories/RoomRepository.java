package com.example.RoomBookingSystem.Repositories;

import com.example.RoomBookingSystem.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
