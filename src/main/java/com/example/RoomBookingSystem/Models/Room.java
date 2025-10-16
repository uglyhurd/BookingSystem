package com.example.RoomBookingSystem.Models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int room_id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    public Room() {
    }

    public Room(List<Bookings> bookingsList, String location, int capacity, String name) {
        this.bookingsList = bookingsList;
        this.location = location;
        this.capacity = capacity;
        this.name = name;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public List<Bookings> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(List<Bookings> bookingsList) {
        this.bookingsList = bookingsList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Bookings> bookingsList;

}
