package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Seat;

import java.util.List;

public interface SeatRepo {
    public List<Seat> getSeatsofEvent(int id);
    public List<Seat> getFreeSeatsEvent(List<Integer> listOfSeatIds,int id);
}
