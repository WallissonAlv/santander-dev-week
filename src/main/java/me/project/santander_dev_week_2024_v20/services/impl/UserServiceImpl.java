package me.project.santander_dev_week_2024_v20.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.santander_dev_week_2024_v20.domain.models.User;
import me.project.santander_dev_week_2024_v20.domain.repositories.UserRepository;
import me.project.santander_dev_week_2024_v20.services.UserService;
import me.project.santander_dev_week_2024_v20.services.exceptions.BusinessException;
import me.project.santander_dev_week_2024_v20.services.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private static final Long UNCHANGEABLE_USER_ID = 1L;
	
	private final UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public User findById(Long id) {
		Optional<User> obj = this.userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public User create(User obj) {
		Optional.ofNullable(obj).orElseThrow(() -> new BusinessException("User to create must not be null!"));
		Optional.ofNullable(obj.getAccount()).orElseThrow(() -> new BusinessException("User Account to create must not be null"));
		Optional.ofNullable(obj.getCard()).orElseThrow(() -> new BusinessException("User Card to create must not be null"));

		this.validateChangeableId(obj.getId(), "created");

		if(userRepository.existsByAccountNumber(obj.getAccount().getNumber())) {
			throw new BusinessException("This account number already exists!");
		}
		if(userRepository.existsByCardNumber(obj.getCard().getNumber())) {
			throw new BusinessException("This card number already exists!");
		}
		
		return this.userRepository.save(obj);
	}

	@Transactional
	public User update(Long id, User update) {
		this.validateChangeableId(id, "updated");
		User obj = this.findById(id);
		if(!obj.getId().equals(update.getId())) {
			throw new BusinessException("Update IDs must be the same!");
		}
		
		obj.setName(update.getName());
		obj.setAccount(update.getAccount());
		obj.setCard(update.getCard());
		obj.setFeatures(update.getFeatures());
		obj.setNews(update.getNews());
		
		return this.userRepository.save(obj);
	}

	@Transactional
	public void delete(Long id) {
		this.validateChangeableId(id, "deleted");
		User obj = this.findById(id);
		this.userRepository.delete(obj);
	}

	private void validateChangeableId(Long id, String operation) {
		if (UNCHANGEABLE_USER_ID.equals(id)) {
			throw new BusinessException("User with ID: "+ UNCHANGEABLE_USER_ID +" cannot be "+operation);
		}
	}
	
}
