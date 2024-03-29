package com.fellipy.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fellipy.workshopmongodb.domain.User;
import com.fellipy.workshopmongodb.dto.UserDTO;
import com.fellipy.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateUSer(newUser, user);
		return repository.save(user); 
	}
	
	private void updateUSer(User newUser, User user) {
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		
	}

	public User fromDto(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
