package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> listUpcomingEvents();
}
