package com.alarm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.server.Entity.Emergency;
import com.alarm.server.Entity.biz.EmergencyRepository;

@Controller
@RequestMapping(path = "emergency")
public class EmergencyController {
	@Autowired
	EmergencyRepository emergencyRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String id_card, @RequestParam String location) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Emergency emergency = new Emergency(id_card, location);
		emergencyRepository.save(emergency);
		return emergency.getId().toString();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Emergency> getAllUsers() {
		// This returns a JSON or XML with the users
		return emergencyRepository.findAll();
	}

	@GetMapping(path = "/del")
	public @ResponseBody String delUser(@RequestParam Long id) {
		Emergency emergency = emergencyRepository.findOne(id);
		emergencyRepository.delete(emergency);
		return "del" + id;
	}

	@GetMapping(path = "/update")
	public @ResponseBody String update(@RequestParam Long id, @RequestParam String location,
			@RequestParam String id_card) {
		Emergency emergency = emergencyRepository.findOne(id);

		emergencyRepository.save(emergency);
		return emergency.toString();
	}
}
