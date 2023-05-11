package com.example.ticketingapp.controller;

import com.example.ticketingapp.entity.Event;
import com.example.ticketingapp.entity.Seat;
import com.example.ticketingapp.entity.Ticket;
import com.example.ticketingapp.service.EventService;
import com.example.ticketingapp.service.SeatLockService;
import com.example.ticketingapp.service.SeatService;
import com.example.ticketingapp.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MainController {

    private final EventService eventService;
    private final SeatService seatService;
    private final TicketService ticketService;
    private final SeatLockService seatLockService;

    @GetMapping("/listupcomingevents")
    public List<Event> listUpcomingEvents(){
        return eventService.listUpcomingEvents();
    }


    @GetMapping("/getseatsevent/{id}")
    public List<Seat> getSeatsEvent(@PathVariable int id){
        return seatService.getSeatsofEvent(id);
    }

    @GetMapping("/getticketsevent/{id}")
    public List<Ticket> getTicketsEvent(@PathVariable int id){
        return ticketService.getSeatsofEvent(id);
    }


    @GetMapping("/getfreeseatsevent/{id}")
    public List<Seat> getFreeSeatsEvent(@PathVariable int id){
        List<Integer> ticketsOfEvent = ticketService.getBoughtTicketsofEvent(id);
        return seatService.getFreeSeatsEvent(ticketsOfEvent,id);
    }

    @PostMapping("/createticket/{ownerName}/{idEvent}/{idSeat}")
    public String createTicket(@PathVariable String ownerName,@PathVariable int idEvent,@PathVariable int idSeat){
        List<Integer> boughtTickets = ticketService.getBoughtTicketsofEvent(idEvent);
        boolean isBought = false;
        for (int i = 0; i < boughtTickets.size(); i++) {
            if (boughtTickets.get(i)==idSeat){
                isBought=true;
                return "The Seat is already taken.Please choose another one...";
            }
        }
        ticketService.createTicket(ownerName,idEvent,idSeat);
        return "Ticket is succesfully bought";
    }

    @PostMapping("/cancelticket/{ownerName}/{idEvent}/{idSeat}")
    public void cancelTicket(@PathVariable String ownerName,@PathVariable int idEvent,@PathVariable int idSeat){
        ticketService.cancelTicket(ownerName,idEvent,idSeat);
    }

    @PostMapping("/createseatlock/{idEvent}/{idSeat}")
    public String createSeatLock ( @PathVariable int idEvent, @PathVariable int idSeat){
        List<Integer> boughtTickets = ticketService.getBoughtTicketsofEvent(idEvent);
        boolean isBought = false;
        for (int i = 0; i < boughtTickets.size(); i++) {
            if (boughtTickets.get(i)==idSeat){
                isBought=true;
                return "The Seat is already taken.Please choose another one...";
            }
        }
        //check all ticketlocks
        if(seatLockService.isSeatReserved(idEvent,idSeat)){
            return "The Seat is already reserved. Please choose another one";
        }
        else {
            return "Your Seat Lock code is : " + seatLockService.createSeatLock(idEvent, idSeat);
        }
        }


}
