package com.example.ticketingapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Event")
public class Event {

    enum myEnum{
        Available,Cancelled,Finished
    }

    @Id
    @Column(name="IdEvent")
    private int idEvent;

    @Column(name = "Name")
    private String name;

    @Column(name = "EventStart")
    private Date dateTime;

    @Column(name = "State")
    private myEnum state;

    public Event() {
    }

    public Event(int idEvent, String name, Date dateTime, myEnum state) {
        this.idEvent = idEvent;
        this.name = name;
        this.dateTime = dateTime;
        this.state = state;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public myEnum getState() {
        return state;
    }

    public void setState(myEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", state=" + state +
                '}';
    }
}
