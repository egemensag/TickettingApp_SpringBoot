package com.example.ticketingapp.repository;

import com.example.ticketingapp.entity.Seat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SeatRepoImpl implements SeatRepo{

    private EntityManager entityManager;

    public SeatRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Seat> getSeatsofEvent(int id) {
        String x = "select * from Seat where(IdEvent="+ id +")";
        Query q = entityManager.createNativeQuery(x);
        return q.getResultList();
    }

    @Override
    public List<Seat> getFreeSeatsEvent(List<Integer> listOfSeatIds, int id) {
        String idsString = "";

        for (int i =0;i<listOfSeatIds.size();i++){
            idsString+=" AND Seat.IdSeat!=" + listOfSeatIds.get(i);
        }
        idsString+=" ;";
        String x = "select * from Seat where Seat.IdEvent="+ id + idsString;
        Query q = entityManager.createNativeQuery(x);
        return q.getResultList();
    }
}
