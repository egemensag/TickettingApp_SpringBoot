package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventRepoImpl implements EventRepo{

    private EntityManager entityManager;

    public EventRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public List<Event> listUpcomingEvents() {
        Query q = entityManager.createNativeQuery(" select * from event where EventStart > DATE(NOW()) AND (State != 'Cancelled')" );
        return q.getResultList();
    }
}
