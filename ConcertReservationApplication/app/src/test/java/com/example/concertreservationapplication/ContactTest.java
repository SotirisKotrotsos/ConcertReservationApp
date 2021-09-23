package com.example.concertreservationapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.concertreservationapplication.domain.*;
import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact, contact1;
    @Before
    public void setUp() throws Exception{
        contact = new Contact("694444444","sot@gmail.com");
        contact1 = new Contact("69555555","raf@gmail.com");
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getPhone_number() {
        assertEquals("694444444",contact.getPhone_number());
    }

    @Test
    public void setPhone_number() {
        contact.setPhone_number("693333333");
        assertEquals("693333333",contact.getPhone_number());
    }

    @Test
    public void getEmail() {
        assertEquals("sot@gmail.com",contact.getEmail());
    }

    @Test
    public void setEmail() {
        contact.setEmail("Sot@gmail.com");
        assertEquals("Sot@gmail.com",contact.getEmail());
    }

    @Test
    public void testEquals() {
        assertEquals(false,contact.equals(contact1));
    }
}