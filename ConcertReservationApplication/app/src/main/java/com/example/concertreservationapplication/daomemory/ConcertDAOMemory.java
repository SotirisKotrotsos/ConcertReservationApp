package com.example.concertreservationapplication.daomemory;

import com.example.concertreservationapplication.domain.*;

import java.util.ArrayList;
import java.util.List;

import com.example.concertreservationapplication.dao.ConcertDAO;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class ConcertDAOMemory implements ConcertDAO {

    protected static List<Concert> concertsList = new ArrayList<>();

    @Override
    public Concert find(String title) {
        for(Concert concert: concertsList){
            if (concert.getTitle().equals(title)){
                return concert;
            }
        }
        return null;
    }

    @Override
    public void save(Concert concert) {
        if (! concertsList.contains(concert)){
            concertsList.add(concert);
        }
    }

    @Override
    public Concert delete(Concert concert) {
        concertsList.remove(concert);
        return concert;
    }

    @Override
    public List<Concert> findAll() {
        return new ArrayList<Concert>(concertsList);
    }
}
