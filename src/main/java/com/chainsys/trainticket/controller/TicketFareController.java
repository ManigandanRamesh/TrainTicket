package com.chainsys.trainticket.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.trainticket.compositekey.TicketFareCompositeKey;
import com.chainsys.trainticket.model.TicketFare;
import com.chainsys.trainticket.model.User;
import com.chainsys.trainticket.service.TicketFareService;


@Controller
@RequestMapping("/ticketfare")
public class TicketFareController {
	@Autowired
	TicketFareService ticfareservice;
	 
	@GetMapping("/listtktfare")
	public String getTicketFares(@RequestParam("trainNo")int trainNo,Model model) {
		List<TicketFare> theTf= ticfareservice.findByTrainNo(trainNo);
		model.addAttribute("alltktfare", theTf);
		return "list-ticket-fare-form";
	}
	@GetMapping("/addticketfareform")
	public String AddTicketFare(Model model) {
		TicketFare theTf = new TicketFare();
		model.addAttribute("addtktfare", theTf);
		return "add-ticket-fare-form";
	}

	@PostMapping("/newticketfare")
	public String addtkfare(@Valid @ModelAttribute("addtktfare") TicketFare theTf,Errors errors) {
		if(errors.hasErrors()) {
			return "add-ticket-fare-form";
		}
		ticfareservice.save(theTf);
		return "redirect:/ticketfare/listtktfare";
    }
	@GetMapping("/modifyticketfare")
	public String updateTicketFare() {
	   
		return "modifyticketfareform";
	}
	@GetMapping("/updateticketfareform")
	public String updateTicketFareForm(@RequestParam("TrainNo")int id,@RequestParam("class")String sid, Model model) {
		TicketFareCompositeKey ticketFareCompositeKey=new TicketFareCompositeKey(id,sid);
		Optional<TicketFare> theTn = ticfareservice.findByid(ticketFareCompositeKey);
		model.addAttribute("updatetkfare", theTn);
		return "update-ticket-fare-form";
	}

	@PostMapping("/updatetf")
	public String modifyticketfare(@Valid @ModelAttribute("updatetkfare") TicketFare theTf,Errors errors) {
		if (errors.hasErrors()) {
			return "update-ticket-fare-form";
		}
		ticfareservice.save(theTf);
		return "redirect:/ticketfare/listtktfare";
	}
	@GetMapping("/deleteticketfare")
	public String deleteTicketFare() {
	   
		return "deleteticketfareform";
	}
	@GetMapping("/deleteticketfareform")
	public String deleteticketfare(@RequestParam("TrainNo") int id,@RequestParam("class")String sid) {
		TicketFareCompositeKey ticketFareCompositeKey=new TicketFareCompositeKey(id,sid);
		Optional<TicketFare> theFare = ticfareservice.findByid(ticketFareCompositeKey);
		ticfareservice.deleteById(ticketFareCompositeKey);
		return "redirect:/ticketfare/listtktfare";
	}
	@GetMapping("/findticketfare")
	public String getTicketFare() {
	   
		return "findticketfareform";
	}

	@GetMapping("/getticketfarebyno")
	public String getticketbyid(@RequestParam("TrainNo") int id,@RequestParam("class")String sid, Model model) {
		TicketFareCompositeKey ticketFareCompositeKey=new TicketFareCompositeKey(id,sid);
		Optional<TicketFare> theFare = ticfareservice.findByid(ticketFareCompositeKey);
		model.addAttribute("getticketfarebynum", theFare);
		return "find-ticket-fare-by-ticketnum";
	}
	@GetMapping("/findbytrainnno")
	public String getTicketFare(@RequestParam("TrainNo") int id, Model model) {
		List<TicketFare> ticketFare = ticfareservice.findByTrainNo(id);
			model.addAttribute("getticketfarebynum", ticketFare);
			return "find-ticket-fare-by-ticketnum";
	}


}
