package com.example.concertreservationapplication.dao;

import com.example.concertreservationapplication.domain.*;

import java.util.List;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface ConcertDAO {
    public Concert find(String title);
    public void save(Concert concert);
    public Concert delete(Concert concert);
    public List<Concert> findAll();

}
