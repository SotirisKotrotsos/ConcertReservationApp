package com.example.concertreservationapplication.domain;
import java.util.*;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class Consumer {

    private String first_name;
    private String last_name;
    private Contact contact;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    /**
     * constructor for Consumer
     * @param first_name
     * @param last_name
     * @param contact
     */
    public Consumer(String first_name, String last_name, Contact contact) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact = contact;
    }

    /**
     * default constructor
     */
    public Consumer() {
    }

    /**
     * get the first name
     * @return
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * set the first name
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * get the last name
     * @return
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * set the last name
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * get the email from the contact
     * @return
     */
    public String getEmail() {
        return contact.getEmail();
    }

    /**
     * set the email on contact
     * @param email
     */
    public void setEmail(String email) {
        this.contact.setEmail(email);
    }

    /**
     * get the phone number from contact
     * @return
     */
    public String getPhone_number() {
        return contact.getPhone_number();
    }

    /**
     * set the phone number on contact
     * @param phone_number
     */
    public void setPhone_number(String phone_number) {
        this.contact.setPhone_number(phone_number);
    }

    /**
     * get all booked tickets of current consumer
     * @return
     */
    public ArrayList<Ticket> getBooked() {
        return tickets;
    }

    /**
     * reserve a ticket
     * should return true if reserved with success
     * and false if consumer already reserved this ticket
     * @param ticket
     * @return
     */
    public boolean reserveTicket(Ticket ticket){

        if(tickets.contains(ticket)){
            return false;
        }
        tickets.add(ticket);

        return true;
    }


    public void sendEmail(String message){
        System.out.print(message);
    }

    /**
     * purchase a ticket
     * should return true if purchase the ticket with success
     * and false if consumer already bought this ticket
     * @param ticket
     * @return
     */
    public boolean purchaseTicket(Ticket ticket){

        if(tickets.contains(ticket)){

            if (ticket.isPayed()){
                return false;
            }
            ticket.buyTicket();

            return true;
        }

        if (!ticket.isPayed()) {
            ticket.buyTicket();
            tickets.add(ticket);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * cancel the chosen ticket, checks if ticket doesn't exist
     * @param ticket
     * @return
     */
    public boolean cancelTicket(Ticket ticket){

        if(!tickets.contains(ticket)) return false;

        tickets.remove(ticket);

        return true;

    }

    /**
     * check if two consumer haw same values
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return Objects.equals(first_name, consumer.first_name) &&
                Objects.equals(last_name, consumer.last_name) &&
                Objects.equals(contact, consumer.contact) &&
                Objects.equals(tickets, consumer.tickets);
    }
}
