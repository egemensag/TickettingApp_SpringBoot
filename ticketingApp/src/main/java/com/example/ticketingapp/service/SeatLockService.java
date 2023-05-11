package com.example.ticketingapp.service;

public interface SeatLockService {
    public String createSeatLock(int idEvent, int idSeat);
    public boolean isSeatReserved(int idEvent, int idSeat);
}
