package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TicketRepoImpl implements TicketRepo{

    private EntityManager entityManager;

    public TicketRepoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public List<Ticket> getAllTicketsofEvent(int id) {
        String x = "select * from Ticket where(IdEvent="+ id +")";
        Query q = entityManager.createNativeQuery(x);
        return q.getResultList();
    }

    @Override
    @Transactional
    public List<Integer> getBoughtTicketsofEvent(int id) {
        String x = "select IdSeat from Ticket where(Ticket.IdEvent=" + id +" AND NOT Ticket.State='Cancelled')";
        Query q = entityManager.createNativeQuery(x);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void createTicket(String ownerName,int idEvent,int idSeat) {
        String x = "INSERT INTO Ticket(OwnerName,CreatedAt,State,IdEvent,IdSeat) VALUES('"+ownerName+"'," +"NOW(),'Valid',"+idEvent+","+idSeat+")";
        Query q = entityManager.createNativeQuery(x);
        q.executeUpdate();
    }



    @Override
    @Transactional
    public void cancelTicket(String ownerName,int idEvent,int idSeat) {
        String x ="UPDATE Ticket Set Ticket.State = 'Cancelled' WHERE Ticket.OwnerName='"+ownerName+"' AND Ticket.IdEvent="+idEvent+" AND Ticket.IdSeat="+idSeat;
        Query q = entityManager.createNativeQuery(x);
        q.executeUpdate();
    }
}
