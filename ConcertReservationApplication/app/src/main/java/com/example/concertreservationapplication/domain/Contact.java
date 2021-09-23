package com.example.concertreservationapplication.domain;

import java.util.Objects;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class Contact {

    String phone_number;
    String email;

    /**
     * constructor of Contact
     * @param phone_number
     * @param email
     */
    public Contact(String phone_number, String email) {
        this.phone_number = phone_number;
        this.email = email;
    }

    /**
     * default constructor
     */
    public Contact() {
    }

    /**
     * get the value of phone number
     * @return
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * set the value of phone number
     * @param phone_number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * get the value of email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set the value of email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * check if two instances of contact has same values
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phone_number, contact.phone_number) &&
                Objects.equals(email, contact.email);
    }
}
