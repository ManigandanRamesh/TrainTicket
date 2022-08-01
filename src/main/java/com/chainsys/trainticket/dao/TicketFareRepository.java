package com.chainsys.trainticket.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.trainticket.model.TicketFare;


public interface TicketFareRepository  extends CrudRepository<TicketFare,Integer> {
 	TicketFare findById(int id);
 	
 	TicketFare save(TicketFare tf);
 	
 	// Used for adding new doctor
 	void deleteById(int id);
 	
 	List<TicketFare> findAll(); 

}
