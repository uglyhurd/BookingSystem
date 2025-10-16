package com.example.RoomBookingSystem.Controllers;

import com.example.RoomBookingSystem.Models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
public class MainController {

    @GetMapping()
    public String mainPage(Model model){

        return "BookingMenu";

    }

    @GetMapping("/getData")
    public String getData(@RequestParam("date") String date){
        System.out.printf(date);
        return "redirect:/booking";
    }



}
