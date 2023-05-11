package com.example.ticketingapp.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class SeatLockRepoImpl implements SeatLockRepo{

    private EntityManager entityManager;

    public SeatLockRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public String createSeatLock(int idEvent, int idSeat) {
        String lockCode="";
        for (int i = 0; i < 5; i++) {
            int randomNumber = (int) (1 + (Math.random() * 9));
            lockCode+=randomNumber;
        }

        String x = "INSERT INTO SeatLock(CreationTime,ValidUntil,LockCode,IdEvent,IdSeat) VALUES(NOW(),NOW() + interval 30 day,"+lockCode+","+idEvent+","+idSeat+")";
        Query q = entityManager.createNativeQuery(x);
        q.executeUpdate();
        return lockCode;

    }

    @Override
    @Transactional
    public boolean isSeatReserved(int idEvent, int idSeat) {
        String x = "select exists(select * from SeatLock where SeatLock.idSeat ="+ idSeat +")";
        Query q = entityManager.createNativeQuery(x);
        if (q.getResultList().get(0).equals(0)){
            return false;
        }
        return true;
        }
}
