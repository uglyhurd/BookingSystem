package com.example.RoomBookingSystem.Controllers;

import com.example.RoomBookingSystem.Models.Room;
import com.example.RoomBookingSystem.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
