package me.project.santander_dev_week_2024_v20.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User obj) {
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User obj){
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
