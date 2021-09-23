package com.example.concertreservationapplication.dao;

import com.example.concertreservationapplication.domain.*;

import java.util.List;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface ConsumerDAO {

    public Consumer find(String phone);
    public void save(Consumer consumer);
    public Consumer delete(Consumer consumer);
    public List<Consumer> findAll();
}
