package me.project.santander_dev_week_2024_v20.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.domain.repositories.UserRepository;
import me.project.santander_dev_week_2024_v20.services.exceptions.DatabaseException;
import me.project.santander_dev_week_2024_v20.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Transactional
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	@Transactional
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	@Transactional
	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity,obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	@Transactional
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	private void updateData(User entity, User obj) {
		entity.setId(obj.getId());
		entity.setName(obj.getName());
		entity.setAccount(obj.getAccount());
		entity.setCard(obj.getCard());
	}
}
