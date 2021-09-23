package com.example.concertreservationapplication.domain;

import java.util.*;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class Ticket{

    private String category;
    private long ticket_number;
    private Consumer consumer;
    private Concert concert;
    private float price_of_grandstand_ticket;
    private boolean isPayed;

    /**
     * Constructor fo ticket
     * @param category
     * @param ticket_number
     * @param consumer
     * @param isPayed
     * @param concert
     */
    public Ticket(String category, long ticket_number, Consumer consumer, boolean isPayed, Concert concert) {
        this.category = category;
        this.ticket_number = ticket_number;
        this.consumer = consumer;
        this.concert = concert;
        this.isPayed = isPayed;
    }

    /**
     * Constructor with default value not payed on ticket
     * @param category
     * @param ticket_number
     * @param consumer
     * @param price_of_grandstand_ticket
     * @param concert
     */
    public Ticket(String category, long ticket_number, Consumer consumer,float price_of_grandstand_ticket,Concert concert) {
        this.category = category;
        this.ticket_number = ticket_number;
        this.consumer = consumer;
        this.price_of_grandstand_ticket = category.equals("arena") ? 2*price_of_grandstand_ticket : price_of_grandstand_ticket;
        this.isPayed = false;
        this.concert = concert;
    }

    /**
     * default constructor
     */
    public Ticket() {
    }

    /**
     * getCategory
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * setCategory
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * getTicket
     * @return
     */
    public long getTicket_number() {
        return ticket_number;
    }

    /**
     * setTicket
     * @param ticket_number
     */
    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    /**
     * getConsumer
     * @return
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     * setConsumer
     * @param consumer
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    /**
     * getConcert
     * @return
     */
    public Concert getConcert() {
        return concert;
    }

    /**
     * setConcert
     * @param concert
     */
    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    /**
     * getPrice_of_grandstand_ticket
     * @return
     */
    public float getPrice_of_grandstand_ticket() {
        return price_of_grandstand_ticket;
    }

    /**
     * setPrice_of_grandstand_ticket
     * @param price_of_grandstand_ticket
     */
    public void setPrice_of_grandstand_ticket(float price_of_grandstand_ticket) {
        this.price_of_grandstand_ticket = price_of_grandstand_ticket;
    }

    /**
     * check if ticket is payed
     * @return
     */
    public boolean isPayed() {
        return isPayed;
    }

    /**
     * check if a ticket is already payed else change its value to payed
     */
    public void buyTicket(){
        if (isPayed) {
            System.out.print("This ticket is already payed!");
        }
        else {
            isPayed = true;
        }
    }

    /**
     * it checks if trying to cancel non purchased ticket, if not it cancels it
     */
    public void cancelPurchaseTicket(){
        if (!isPayed){
            System.out.print("Τhe ticket has not been paid");
        }
        else {
            isPayed = false;
        }
        concert.cancelOneTicket(this);
    }

    /**
     * check two instances of ticket has same values
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticket_number == ticket.ticket_number &&
                isPayed == ticket.isPayed &&
                Objects.equals(category, ticket.category) &&
                Objects.equals(consumer, ticket.consumer) &&
                Objects.equals(concert, ticket.concert);
    }

}
