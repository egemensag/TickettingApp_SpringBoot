package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Ticket;

import java.util.List;

public interface TicketRepo {
    List<Ticket> getAllTicketsofEvent(int id);
    List<Integer> getBoughtTicketsofEvent(int id);
    public void createTicket(String ownerName,int idEvent,int idSeat);
    public void cancelTicket(String ownerName,int idEvent,int idSeat);
}
