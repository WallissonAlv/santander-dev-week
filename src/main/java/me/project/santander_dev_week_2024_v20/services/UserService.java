package me.project.santander_dev_week_2024_v20.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.domain.repositories.UserRepository;
import me.project.santander_dev_week_2024_v20.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
