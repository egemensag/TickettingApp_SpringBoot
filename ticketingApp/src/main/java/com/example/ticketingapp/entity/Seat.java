package com.example.ticketingapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Seat")
public class Seat {

    @Id
    @Column(name="IdSeat")
    private int idSeat;

    @Column(name = "Srow")
    private String sRow;

    @Column(name = "SeatNumber")
    private int seatNumber;

    @Column(name = "IdEvent")
    private int IdEvent;

    public Seat() {
    }

    public Seat(int idSeat, String sRow, int seatNumber, int idEvent) {
        this.idSeat = idSeat;
        this.sRow = sRow;
        this.seatNumber = seatNumber;
        IdEvent = idEvent;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public String getsRow() {
        return sRow;
    }

    public void setsRow(String sRow) {
        this.sRow = sRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int idEvent) {
        IdEvent = idEvent;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "idSeat=" + idSeat +
                ", sRow='" + sRow + '\'' +
                ", seatNumber=" + seatNumber +
                ", IdEvent=" + IdEvent +
                '}';
    }
}
