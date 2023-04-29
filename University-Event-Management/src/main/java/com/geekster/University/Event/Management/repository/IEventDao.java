package com.geekster.University.Event.Management.repository;

import com.geekster.University.Event.Management.models.EventModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IEventDao extends CrudRepository <EventModel , Integer> {




    @Modifying
    @Query(value = "update event_model set event_location=:location where event_id=:id" ,nativeQuery = true )
    public void updateLocationById(Integer id, String location);

   public ArrayList<EventModel> findByDate(String date);
}
