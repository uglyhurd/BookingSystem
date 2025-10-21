package com.example.RoomBookingSystem.Controllers;

import com.example.RoomBookingSystem.Models.Bookings;
import com.example.RoomBookingSystem.Models.Room;
import com.example.RoomBookingSystem.Services.BookingService;
import com.example.RoomBookingSystem.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/booking")
public class MainController {

    public final RoomService roomService;
    private final BookingService bookingService;

    @Autowired
    public MainController(RoomService roomService, BookingService bookingService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    @GetMapping()
    public String mainPage(Model model){

        return "BookingMenu";

    }

    @GetMapping("/getData")
    public String getData(@RequestParam("date") String date, Model model){
        model.addAttribute("date", date);
        model.addAttribute("rooms", roomService.allRooms());
        System.out.printf(date);
        return "allRooms";
    }

    @PostMapping("/bookAroom/{roomId}")
    public String addBooking(@ModelAttribute("booking")Bookings booking,
                             @PathVariable("roomId") int roomId ){
        booking.setRoom(roomService.getRoom(roomId));
        bookingService.saveBooking(booking);

        return "BookingMenu";
    }




}
