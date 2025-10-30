package com.example.RoomBookingSystem.Services;

import com.example.RoomBookingSystem.Models.Bookings;
import com.example.RoomBookingSystem.Models.Room;
import com.example.RoomBookingSystem.Repositories.BookingRepository;
import com.example.RoomBookingSystem.Repositories.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoomService {


    private final BookingRepository bookingRepository;
    public int count;

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public void saveRoom(Room room){
        roomRepository.save(room);
    }


    public List<Room> allRooms(){
        return roomRepository.findAll();
    }

    public Room getRoom(int id){
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }

    public int roomCounter(){
        return count++;
    }

    public Optional<Room> showRoom(int id){
        return roomRepository.findById(id);
    }



}
