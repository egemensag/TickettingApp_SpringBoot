package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Ticket;
import com.example.ticketingapp.repository.TicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketServiceImpl implements TicketService{

    private final TicketRepo ticketRepo;

    @Override
    public List<Ticket> getSeatsofEvent(int id) {
        return ticketRepo.getAllTicketsofEvent(id);
    }

    @Override
    public List<Integer> getBoughtTicketsofEvent(int id) {
        return ticketRepo.getBoughtTicketsofEvent(id);
    }

    @Override
    public void createTicket(String ownerName,int idEvent,int idSeat) {
        ticketRepo.createTicket(ownerName,idEvent,idSeat);
    }

    @Override
    public void cancelTicket(String ownerName,int idEvent,int idSeat) {
        ticketRepo.cancelTicket(ownerName,idEvent,idSeat);
    }
}
