package com.example.ticketingapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SeatLock")
public class SeatLock {

    @Id
    @Column(name = "IdSeatLock")
    private int idSeatLock;

    @Column(name = "CreationTime")
    private Date creationTime;

    @Column(name = "ValidUntil")
    private Date validUntil;

    @Column(name = "LockCode")
    private String lockCode;

    @Column(name = "IdEvent")
    private int idEvent;

    @Column(name = "IdSeat")
    private int idSeat;

    public SeatLock() {
    }

    public SeatLock(int idSeatLock, Date creationTime, Date validUntil, String lockCode, int idEvent, int idSeat) {
        this.idSeatLock = idSeatLock;
        this.creationTime = creationTime;
        this.validUntil = validUntil;
        this.lockCode = lockCode;
        this.idEvent = idEvent;
        this.idSeat = idSeat;
    }

    public int getIdSeatLock() {
        return idSeatLock;
    }

    public void setIdSeatLock(int idSeatLock) {
        this.idSeatLock = idSeatLock;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public String getLockCode() {
        return lockCode;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    @Override
    public String toString() {
        return "SeatLock{" +
                "idSeatLock=" + idSeatLock +
                ", creationTime=" + creationTime +
                ", validUntil=" + validUntil +
                ", lockCode='" + lockCode + '\'' +
                ", idEvent=" + idEvent +
                ", idSeat=" + idSeat +
                '}';
    }
}
