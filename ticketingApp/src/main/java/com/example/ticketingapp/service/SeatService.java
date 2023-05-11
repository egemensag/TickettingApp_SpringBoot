package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsofEvent(int id);
    List<Seat> getFreeSeatsEvent(List<Integer> listOfSeatIds,int id);
}
