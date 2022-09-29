package com.maven.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.student.dto.User;

	@Service
	public class UserService {
	@Autowired
	UserRepository userRepository;
	public List<User> getAllUsers()
	{
	List<User> userlist = (List<User>) userRepository.findAll();
	return userlist;
	}
	public User getUsersByUserId(String userid) {
	
	return userRepository.findByUserId(userid);
	
	}
	
	public User save (User user) {
		return userRepository.save(user);
	}
	public void delete (String userid) {
		userRepository.deleteById(userid);
	}
	public User update (User user,String userid) {
		return userRepository.save(user);
	}
	public List<User> searchUser(String userid, String username){
	    List<User> list=userRepository.searchUser(userid, username);
	    return list;
	}
}
