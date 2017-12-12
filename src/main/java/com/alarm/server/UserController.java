package com.alarm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.server.Entity.User;
import com.alarm.server.Entity.biz.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String phone,
			@RequestParam String id_card) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setId_card(id_card);
		userRepository.save(user);
		return "ok";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@GetMapping(path = "/del")
	public @ResponseBody String delUser(@RequestParam Long id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);
		return "del" + id;
	}

	@GetMapping(path = "/update")
	public @ResponseBody String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String phone,
			@RequestParam String id_card) {
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setId_card(id_card);
		userRepository.save(u);
		return u.toString();
	}
}
