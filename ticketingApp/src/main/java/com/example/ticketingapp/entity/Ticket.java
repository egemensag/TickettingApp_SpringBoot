package com.example.ticketingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Ticket")
public class Ticket {

    enum myEnum{
        Valid,Cancelled
    }

    @Id
    @Column(name = "IdTicket")
    private int idTicket;

    @Column(name = "OwnerName")
    private String ownerName;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "State")
    private myEnum state;

    @Column(name = "IdEvent")
    private int idEvent;

    @Column(name = "IdSeat")
    private int idSeat;

    public Ticket() {
    }

    public Ticket(int idTicket, String ownerName, Date createdAt, myEnum state, int idEvent, int idSeat) {
        this.idTicket = idTicket;
        this.ownerName = ownerName;
        this.createdAt = createdAt;
        this.state = state;
        this.idEvent = idEvent;
        this.idSeat = idSeat;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public myEnum getState() {
        return state;
    }

    public void setState(myEnum state) {
        this.state = state;
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
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", ownerName='" + ownerName + '\'' +
                ", createdAt=" + createdAt +
                ", state=" + state +
                ", idEvent=" + idEvent +
                ", idSeat=" + idSeat +
                '}';
    }
}
