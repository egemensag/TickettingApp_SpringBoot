package com.example.ticketingapp.service;

import com.example.ticketingapp.entity.Event;
import com.example.ticketingapp.repository.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService{

    private final EventRepo eventRepo;

    @Override
    public List<Event> listUpcomingEvents() {
        return eventRepo.listUpcomingEvents();
    }
}
