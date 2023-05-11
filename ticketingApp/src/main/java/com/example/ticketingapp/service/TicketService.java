package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Ticket;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TicketService {
    List<Ticket> getSeatsofEvent(int id);
    List<Integer> getBoughtTicketsofEvent(int id);
    public void createTicket(String ownerName,int idEvent,int idSeat);
    public void cancelTicket(String ownerName,int idEvent,int idSeat);
}
