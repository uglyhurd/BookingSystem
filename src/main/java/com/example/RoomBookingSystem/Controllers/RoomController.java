package com.example.RoomBookingSystem.Controllers;

import com.example.RoomBookingSystem.Models.Bookings;
import com.example.RoomBookingSystem.Models.Room;
import com.example.RoomBookingSystem.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/booking")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/NewRoom")
    public String newRoom(Model model){
        model.addAttribute("room", new Room());
        return "NewRoom";
    }

    @PostMapping("/newRoom")
    public String addRoom(@ModelAttribute("room") Room room){

        roomService.saveRoom(room);

        return "/BookingMenu";
    }

    @GetMapping("/getRoom/{id}")
    public String getRoom(Model model, @PathVariable("id") int id){


        model.addAttribute("room", roomService.getRoom(id));
        model.addAttribute("booking", new Bookings());
        model.addAttribute("date", LocalDate.now());


        return "Room";
    }

    @GetMapping("/allRooms")
    public String allRooms(Model model){
        model.addAttribute("rooms", roomService.allRooms());
        model.addAttribute("counter", roomService.roomCounter());
        return "allRoomsCRUD";

    }
    @GetMapping("/showRoom/{id}")
    public String showRoom(@PathVariable("id") int id ,Model model){
        model.addAttribute("room", roomService.showRoom(id));
//        if(roomService.showRoom(id).isPresent()){
        model.addAttribute("roomBookings", roomService.showRoom(id).get().getBookingsList());
//        } else if (roomService.showRoom(id).isEmpty()){
//
//            model.addAttribute("roomBookings", null);
//        }

        return "showRoom";
    }

}
