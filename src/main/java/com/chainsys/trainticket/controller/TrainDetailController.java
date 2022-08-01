package com.chainsys.trainticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.trainticket.model.TrainDetail;
import com.chainsys.trainticket.service.TrainDetailService;



@Controller
@RequestMapping("/traindetails")
public class TrainDetailController {
	@Autowired
	TrainDetailService traindetailservice;
	 
	@GetMapping("/listtrain")
	public String getTrains(Model model) {
		List<TrainDetail> theTn= traindetailservice.getTrainDetails();
		model.addAttribute("alltrains", theTn);
		return "list-train-detail-form";
	}
	@GetMapping("/addform")
	public String AddTrainForm(Model model) {
		TrainDetail theTn = new TrainDetail();
		model.addAttribute("addtrain", theTn);
		return "add-train-detail-form";
	}

	@PostMapping("/newtrain")
	public String addtrain(@ModelAttribute("addtrain") TrainDetail theTn) {
		traindetailservice.save(theTn);
		return "redirect:/traindetails/list-train-detail-form";
}
	@GetMapping("/updateform")
	public String updateTrainDetailForm(@RequestParam("TrainNo")int id, Model model) {
		TrainDetail theTn = traindetailservice.findByid(id);
		model.addAttribute("updatetrain", theTn);
		return "update-train-detail-form";
	}

	@PostMapping("/updatetn")
	public String modifytrain(@ModelAttribute("updatetrain") TrainDetail theTn) {
		traindetailservice.save(theTn);
		return "redirect:/traindetails/list-train-detail-form";
	}
	@GetMapping("/deletetn")
	public String deletetrain(@RequestParam("TrainNo") int id) {
		traindetailservice.deleteById(id);
		return "redirect:/traindetails/list-train-detail-form";
	}

	@GetMapping("/gettrainbyno")
	public String getticketbyid(@RequestParam("TrainNo") int id, Model model) {
		TrainDetail tn = traindetailservice.findByid(id);
		model.addAttribute("gettrainbynum", tn);
		return "find-train-by-num-form";
	}


}