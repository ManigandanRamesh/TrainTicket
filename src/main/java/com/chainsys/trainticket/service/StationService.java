package com.chainsys.trainticket.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.trainticket.dto.StationAndTrainDetailDTO;
import com.chainsys.trainticket.model.Station;
import com.chainsys.trainticket.model.TrainDetail;
import com.chainsys.trainticket.repository.StationRepository;
import com.chainsys.trainticket.repository.TrainDetailRepository;

@Service
public class StationService {
	 @Autowired
	 private  StationRepository stationrepo;
	 @Autowired
	 private TrainDetailRepository trainrepo;
	 
	 public List<Station>getStations(){
		 return stationrepo.findAll();
	 }
//	 @Transactional
		public Station save(Station sn)
		{
			return stationrepo.save(sn);
		}
		public Optional<Station> findByid(String id)
		{
		return stationrepo.findById(id);
		}
//		@Transactional
		public void deleteById(String id)
		{
			stationrepo.deleteById(id);
		}
		public StationAndTrainDetailDTO getStationAndTrainDetailDTO (String name) {
			Optional<Station> station = stationrepo.findById(name);
			StationAndTrainDetailDTO dto = new StationAndTrainDetailDTO();
			dto.setStation(station);
			List<TrainDetail> traindetail = trainrepo.findByStartPlace(name);
			Iterator<TrainDetail> itr = traindetail.iterator();
			while(itr.hasNext()) {
				dto.addTrainDetail(itr.next());
			}
			return dto;
		}
		public StationAndTrainDetailDTO getStationAndTrainDetailDestinationDTO (String name) {
			Optional<Station> station1 = stationrepo.findById(name);
			StationAndTrainDetailDTO dto = new StationAndTrainDetailDTO();
			dto.setStation(station1);
			List<TrainDetail> traindetail1 = trainrepo.findByDestination(name);
			Iterator<TrainDetail> itr = traindetail1.iterator();
			while(itr.hasNext()) {
				dto.addTrainDetail(itr.next());
			}
			return dto;
		}
}
