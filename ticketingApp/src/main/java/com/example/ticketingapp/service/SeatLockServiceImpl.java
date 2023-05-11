package com.example.ticketingapp.service;

import com.example.ticketingapp.repository.SeatLockRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SeatLockServiceImpl implements SeatLockService{

    private final SeatLockRepo seatLockRepo;

    @Override
    public String createSeatLock(int idEvent, int idSeat) {

        return seatLockRepo.createSeatLock(idEvent,idSeat);
    }

    @Override
    public boolean isSeatReserved(int idEvent, int idSeat) {
        return seatLockRepo.isSeatReserved(idEvent,idSeat);
    }
}
