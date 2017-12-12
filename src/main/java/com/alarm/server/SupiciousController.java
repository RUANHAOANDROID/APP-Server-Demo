package com.alarm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.server.Entity.Suspicious;
import com.alarm.server.Entity.biz.SuspiciousRepository;

@Controller
@RequestMapping(path = "supicious")
public class SupiciousController {

	@Autowired
	SuspiciousRepository suspiciousRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String id_card,
			@RequestParam int type, @RequestParam String location,@RequestParam String description) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Suspicious suspicious = new Suspicious(id_card, location, type, description);
		suspiciousRepository.save(suspicious);
		return suspicious.getId().toString();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Suspicious> getAllUsers() {
		// This returns a JSON or XML with the users
		return suspiciousRepository.findAll();
	}

	@GetMapping(path = "/del")
	public @ResponseBody String delUser(@RequestParam Long id) {
		Suspicious suspicious = suspiciousRepository.findOne(id);
		suspiciousRepository.delete(suspicious);
		return "del" + id;
	}

	@GetMapping(path = "/update")
	public @ResponseBody String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String phone,
			@RequestParam String id_card) {
		Suspicious suspicious = new Suspicious();
		suspicious.setId(id);
		suspicious.setId_card(id_card);
		suspiciousRepository.save(suspicious);
		return suspicious.toString();
	}
}
