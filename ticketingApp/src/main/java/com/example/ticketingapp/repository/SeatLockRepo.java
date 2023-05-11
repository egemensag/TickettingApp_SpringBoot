package com.example.ticketingapp.repository;

public interface SeatLockRepo {
    public String createSeatLock(int idEvent, int idSeat);
    public boolean isSeatReserved(int idEvent, int idSeat);
}
