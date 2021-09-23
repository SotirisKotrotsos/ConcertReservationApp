package com.example.concertreservationapplication.daomemory;

import com.example.concertreservationapplication.domain.*;

import java.util.ArrayList;
import java.util.List;

import com.example.concertreservationapplication.dao.ConsumerDAO;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class ConsumerDAOMemory implements ConsumerDAO {

    protected static List<Consumer> consumerList = new ArrayList<>();

    @Override
    public Consumer find(String phone) {
        for(Consumer consumer : consumerList){
            if(consumer.getPhone_number().equals(phone)){
                return consumer;
            }
        }
        return null;
    }

    @Override
    public void save(Consumer consumer) {
        if (!consumerList.contains(consumer)){
            consumerList.add(consumer);
        }
    }

    @Override
    public Consumer delete(Consumer consumer) {
        consumerList.remove(consumer);
        return consumer;
    }

    @Override
    public List<Consumer> findAll() {
        return new ArrayList<Consumer>(consumerList);
    }
}
