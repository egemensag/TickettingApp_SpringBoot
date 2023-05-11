package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Seat;
import com.example.ticketingapp.repository.SeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SeatServiceImpl implements SeatService{

    private final SeatRepo seatRepo;

    @Override
    public List<Seat> getSeatsofEvent(int id) {
        return seatRepo.getSeatsofEvent(id);
    }

    @Override
    public List<Seat> getFreeSeatsEvent(List<Integer> listOfSeatIds,int id) {
        return seatRepo.getFreeSeatsEvent(listOfSeatIds,id);
    }
}
