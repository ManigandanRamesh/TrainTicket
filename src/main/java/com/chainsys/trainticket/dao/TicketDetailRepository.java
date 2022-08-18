package com.chainsys.trainticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.trainticket.compositekey.PaymentDetailCompositeKey;
import com.chainsys.trainticket.compositekey.TicketDetailCompositeKey;
import com.chainsys.trainticket.model.TicketDetail;

public interface TicketDetailRepository extends CrudRepository<TicketDetail,TicketDetailCompositeKey> {
 	Optional<TicketDetail> findById(TicketDetailCompositeKey id);
 	
 	TicketDetail save(TicketDetail td);
 	
 	void deleteById(TicketDetailCompositeKey ticketDetailCompositeKey);
 	
 	List<TicketDetail> findAll(); 
 	
 	List<TicketDetail> findByTicketNo(int id);

 	List<TicketDetail> findByPassengerName(String character);
}