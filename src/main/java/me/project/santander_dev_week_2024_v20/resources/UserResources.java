package me.project.santander_dev_week_2024_v20.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.resources.dto.UserDto;
import me.project.santander_dev_week_2024_v20.services.impl.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
@Tag(name = "User Resource", description = "RESTful api for managing users.")
public class UserResources {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	@Operation(summary = "Get all users", description = "Retrieve a list of all registered users")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Operation sucessful")
	})
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> users = userServiceImpl.findAll();
		List<UserDto> userDto = users.stream().map(UserDto::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(userDto);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get a user by id", description = "Retrieve a specific user based on its ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operation sucessful"),
			@ApiResponse(responseCode = "404", description = "User not found")
	})
	public ResponseEntity<UserDto> findById(@PathVariable Long id){
		User user = userServiceImpl.findById(id);
		return ResponseEntity.ok(new UserDto(user));
	}
	
	@PostMapping
	@Operation(summary = "Create a new user", description = "Create a new user and return the created user`s data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User created sucessful"),
			@ApiResponse(responseCode = "422", description = "Invalid user data provided")
	})
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
		User user = userServiceImpl.create(userDto.toModel());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).body(new UserDto(user));
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Update an user", description = "Update the data of an user based on its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operation sucessful"),
			@ApiResponse(responseCode = "404", description = "User not found"),
			@ApiResponse(responseCode = "422", description = "Invalid user data provided")
	})
	public ResponseEntity<UserDto> update(@PathVariable Long id,@RequestBody UserDto userDto){
		User user = userServiceImpl.update(id, userDto.toModel());
		return ResponseEntity.ok(new UserDto(user));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete an user", description = "Delete an existing user based on its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "User deleted sucessfully"),
			@ApiResponse(responseCode = "404", description = "User not found")
	})
	public ResponseEntity<Void> delele(@PathVariable Long id) {
		userServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}
