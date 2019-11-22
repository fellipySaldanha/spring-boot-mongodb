package com.fellipy.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fellipy.workshopmongodb.domain.User;
import com.fellipy.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
