package com.chainsys.trainticket.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.trainticket.model.TrainDetail;


public interface TrainDetailRepository extends CrudRepository<TrainDetail,Integer> {
 	TrainDetail findById(int id);
 	
 	TrainDetail save(TrainDetail td);
 	
 	void deleteById(int id);
 	
 	List<TrainDetail> findAll(); 
 	
 	List<TrainDetail> findByStartPlace(String name);
 	
 	List<TrainDetail> findByDestination(String value);
 	

}
