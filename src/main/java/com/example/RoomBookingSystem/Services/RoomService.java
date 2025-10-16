package com.example.RoomBookingSystem.Services;

import com.example.RoomBookingSystem.Models.Room;
import com.example.RoomBookingSystem.Repositories.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void saveRoom(Room room){
        roomRepository.save(room);
    }



}
