package com.example.concertreservationapplication.domain;

import java.util.*;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */

public class Concert {

    private Scanner scanner = new Scanner(System.in);
    private String title;
    private Calendar calendar;
    private String location;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private String description;
    private Contact contact;
    private int number_of_grandstand_tickets;
    private int num_grand = 0;
    private int number_of_arena_tickets;
    private int num_arena = 0;
    private float price_of_grandstand_ticket;
    private static long ticket_numbers = 0;

    /**
     * constructor of Concert
     * @param title
     * @param calendar
     * @param location
     * @param description
     * @param contact
     * @param number_of_arena_tickets
     * @param number_of_grandstand_tickets
     * @param price_of_grandstand_ticket
     */
    public Concert(String title, Calendar calendar, String location, String description, Contact contact, int number_of_arena_tickets, int number_of_grandstand_tickets, float price_of_grandstand_ticket) {
        this.title = title;
        this.calendar = calendar;
        this.location = location;
        this.description = description;
        this.contact = contact;
        this.number_of_arena_tickets = number_of_arena_tickets;
        this.number_of_grandstand_tickets = number_of_grandstand_tickets;
        this.price_of_grandstand_ticket = price_of_grandstand_ticket;
    }

    /**
     * defualt constructor
     */
    public Concert() {
    }

    /**
     * get number of grandstand tickets that sold
     * @return
     */
    public int getNum_grand() {
        return num_grand;
    }

    /**
     * raise the sold tickets of grandstand
     */
    public void raiseNum_grand() {
        this.num_grand++;
    }

    /**
     * get number of arena tickets that sold
     * @return
     */
    public int getNum_arena() {
        return num_arena;
    }

    /**
     * raise the sold tickets of arena
     */
    public void raiseNum_arena() {
        this.num_arena++;
    }

    /**
     * get title of concert
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * set the title of concert
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get the calendar
     * @return
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * set the calendar
     * @param calendar
     */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     * get location
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * set location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get contact
     * @return
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * set contact
     * @param contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * get max number of arena that concert has
     * @return
     */
    public int getNumber_of_arena_tickets() {
        return number_of_arena_tickets;
    }

    /**
     * set the max number of arena for concert
     * @param number_of_arena_tickets
     */
    public void setNumber_of_arena_tickets(int number_of_arena_tickets) {
        this.number_of_arena_tickets = number_of_arena_tickets;
    }

    /**
     * get max number of grandstand that concert has
     * @return
     */
    public int getNumber_of_grandstand_tickets() {
        return number_of_grandstand_tickets;
    }

    /**
     * set the max number of grandstand for concert
     * @param number_of_grandstand_tickets
     */
    public void setNumber_of_grandstand_tickets(int number_of_grandstand_tickets) {
        this.number_of_grandstand_tickets = number_of_grandstand_tickets;
    }

    /**
     * get the price of a ticket
     * @return
     */
    public float getPrice_of_grandstand_ticket() {
        return price_of_grandstand_ticket;
    }

    /**
     * set the price of a ticket in concert
     * @param price_of_grandstand_ticket
     */
    public void setPrice_of_grandstand_ticket(float price_of_grandstand_ticket) {
        this.price_of_grandstand_ticket = price_of_grandstand_ticket;
    }

    /**
     * make a reservation of ticket, add this ticket on list with tickets
     * and call reservation method for consumer
     * @param consumer
     * @param typeOfTicket
     * @param choiceToPayTicket
     */
    public void reservationTicket(Consumer consumer,String typeOfTicket, boolean choiceToPayTicket){
        //Ticket ticket = null;

        if (isFull()){
            System.out.print("Concert sold out!");
            return;
        }
        if(!checkCategoryAvailability(typeOfTicket)){
            System.out.print(typeOfTicket + " tickets sold out!");
            return;
        }
        Ticket ticket = new Ticket(typeOfTicket, ticket_numbers++, consumer,this.price_of_grandstand_ticket,this);


        if (typeOfTicket.equals("arena")){
            raiseNum_arena();
        }
        else {
            raiseNum_grand();
        }
        tickets.add(ticket);

        if (choiceToPayTicket)
            consumer.reserveTicket(ticket);
        else
            consumer.purchaseTicket(ticket);
    }


    /**
     * notitfy consumers on concert
     * @param message
     */
    public void notifyConsumers(String message){
        for (int counter = 0; counter < tickets.size(); counter++){
            tickets.get(counter).getConsumer().sendEmail(message);
        }
    }

    /**
     * notitfy consumers with payed tickets
     * @param message
     */
    public void notifyConsumersWithPayedTicket(String message){
        for (int counter = 0; counter < tickets.size(); counter++){
            Ticket ticket = tickets.get(counter);
            if (ticket.isPayed()) {
                ticket.getConsumer().sendEmail(message);
            }
        }
    }

    /**
     * return total revenue of concert
     * @return
     */
    public float totalRevenue(){
        return num_arena*price_of_grandstand_ticket*2 + num_grand*price_of_grandstand_ticket;
    }

    /**
     * get total tickets sold
     * @return
     */
    public int totalTicketsSold(){
        return num_grand+num_arena;
    }

    /**
     * check if concert is full
     * @return
     */
    public boolean isFull(){
        return getNum_arena() >= getNumber_of_arena_tickets() && getNum_grand() >= getNumber_of_grandstand_tickets();
    }

    /**
     * check if chosen category has available tickets
     * @param typeOfTicket
     * @return
     */
    public boolean checkCategoryAvailability(String typeOfTicket){

        if (typeOfTicket.equals("arena")) {
            if (num_arena >= number_of_arena_tickets) {
                return false;
            }
        }
        else if (typeOfTicket.equals("grandstand")) {
            if (num_grand >= number_of_grandstand_tickets) {
                return false;
            }
        }
        return true;
    }


    /**
     * when update concert notify consumers
     */
    public void notifyConsumersOnUpdateConcert(){

        for (int counter = 0; counter < tickets.size(); counter++)
            tickets.get(counter).getConsumer().sendEmail("Changes on concert!");

    }

    /**
     * cancel the concert and call the method of consumers to cancel their tickets
     */
    public void cancelConcert(){

        String cancelConcert = "Cancel concert";
        String returnMoney = "Follow the instructions to...";

        for (int counter = 0; counter < tickets.size(); counter++){

            Ticket ticket = tickets.get(counter);

            Consumer consumer = ticket.getConsumer();

            consumer.sendEmail(cancelConcert);

            if (ticket.isPayed()) consumer.sendEmail(returnMoney);

            consumer.cancelTicket(ticket);

        }

        tickets.clear();
        num_arena = 0;
        num_grand = 0;
    }

    /**
     * cancel a specific ticket
     * @param ticket
     * @return
     */
    public boolean cancelOneTicket(Ticket ticket){

        if (!tickets.contains(ticket)){
            System.out.print("Ticket does not exixst");
            return false;
        }
        tickets.remove(ticket);
        return true;
    }
    public boolean isEmpty(){
        return tickets.isEmpty();
    }


    /**
     * check if two instances of concerts has same values
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return number_of_arena_tickets == concert.number_of_arena_tickets &&
                number_of_grandstand_tickets == concert.number_of_grandstand_tickets &&
                Float.compare(concert.price_of_grandstand_ticket, price_of_grandstand_ticket) == 0 &&
                Objects.equals(title, concert.title) &&
                Objects.equals(calendar, concert.calendar) &&
                Objects.equals(location, concert.location) &&
                Objects.equals(tickets, concert.tickets) &&
                Objects.equals(description, concert.description) &&
                Objects.equals(contact, concert.contact);
    }
}
