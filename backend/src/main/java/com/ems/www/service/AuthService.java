package com.ems.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.www.model.User;
import com.ems.www.repo.UserRepository;

@Service
public class AuthService 
{
	@Autowired
	UserRepository userRepository;
	
	public boolean login(String username,String password)
	{
		User user = userRepository.findByUsername(username);
		
		if(user==null) return false;
		
		return user.getPassword().equals(password);
	}
}