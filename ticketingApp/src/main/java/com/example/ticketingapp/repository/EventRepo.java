package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Event;

import java.util.List;

public interface EventRepo {
    public List<Event> listUpcomingEvents();
}
