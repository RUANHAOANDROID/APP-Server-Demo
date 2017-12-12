package com.alarm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.server.Entity.Alarm;
import com.alarm.server.Entity.biz.AlarmRepository;

@Controller
@RequestMapping(path = "/alarm")
public class AlarmController {
	@Autowired
	AlarmRepository alarmRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewAlarm(@RequestParam String id_card, @RequestParam int type,
			@RequestParam String location,@RequestParam String description) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Alarm alarm = new Alarm(id_card, location, description, type);
		alarmRepository.save(alarm);
		return alarm.toString();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Alarm> getAllUsers() {
		// This returns a JSON or XML with the users
		return alarmRepository.findAll();
	}

	@GetMapping(path = "/del")
	public @ResponseBody String delUser(@RequestParam Long id) {
		Alarm alarm = alarmRepository.findOne(id);
		alarmRepository.delete(alarm);
		return "del" + id;
	}

	@GetMapping(path = "/update")
	public @ResponseBody String update(@RequestParam Long id, @RequestParam String name, @RequestParam String phone,
			@RequestParam String id_card, @RequestParam String location, @RequestParam int type) {
		Alarm alarm = alarmRepository.findOne(id);
		alarm.setId_card(id_card);
		alarm.setLocation(location);
		alarm.setType(type);
		alarmRepository.save(alarm);
		return alarm.toString();
	}
}
