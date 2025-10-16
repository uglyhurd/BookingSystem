package com.example.RoomBookingSystem.Models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "booking")
public class Bookings {

    @Column(name = "booking_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @Column(name = "username")
    private String username;



    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;


    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date start_time;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date end_time;

    @ManyToOne()
    @JoinColumn(name = "roomb_id")
    private Room room;

    public Bookings(Date end_time, Date date, Date start_time, String username) {
        this.end_time = end_time;
        this.date = date;
        this.start_time = start_time;

        this.username = username;
    }

    public Bookings() {}

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }
}
