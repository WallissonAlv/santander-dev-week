package me.project.santander_dev_week_2024_v20.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>>findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
