package com.geekster.University.Event.Management.service;

import com.geekster.University.Event.Management.models.EventModel;
import com.geekster.University.Event.Management.repository.IEventDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventService {
    @Autowired
    IEventDao eventDao;

    public String eventDetails(ArrayList <EventModel> eventList) {
        Iterable<EventModel> addStatus =eventDao.saveAll(eventList);
        if(addStatus != null){
            return "Added successfully....!!";
        }else{
            return "Not Added successfully....!!";
        }
    }

    public String updateEventDetails(Integer id,EventModel evenDetails) {
        boolean updateStatus = eventDao.existsById(id);

          if(updateStatus){
              eventDao.save(evenDetails);
              return "updated successfully....!!";
          }else{
              return "Not updated successfully....!!";
          }
    }

    public void deleteEventDetails(int id) {
        eventDao.deleteById(id);
    }

    public void udateDetails(Integer id, String location) {

    }

    @Transactional
    public void udateEventDetails(Integer id, String location) {
        eventDao.updateLocationById(id,location);
    }

    public ArrayList<EventModel> allEventByDate(String date) {
        return eventDao.findByDate(date);
    }
}
