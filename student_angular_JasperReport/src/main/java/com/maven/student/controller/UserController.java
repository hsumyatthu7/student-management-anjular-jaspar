package com.maven.student.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maven.student.dao.UserService;
import com.maven.student.dto.User;
import com.maven.student.model.UserBean;
import com.maven.student.reportService.UserReportService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private UserReportService reportService;
	
	@ModelAttribute("userBean")
	public UserBean getUserBean() {
		return new UserBean();
	}
	
	@GetMapping("/user/report/{format}")
	public  void generateReport(@PathVariable String format,HttpServletResponse response) throws JRException, IOException{
		reportService.exportReport(format,response);
	}

	@RequestMapping(value="/user" , method = RequestMethod.GET)
    public List<User> displayView(ModelMap model) { 
		return userservice.getAllUsers();}
	
	@PostMapping(value="/user",produces = "application/json")
	public User adduser(@RequestBody User user) {

		User dto = new User();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setUserEmail(user.getUserEmail());
        dto.setUserPassword(user.getUserPassword());
        dto.setUserConfirmpassword(user.getUserConfirmpassword());
        dto.setUserRole(user.getUserRole());
		return userservice.save(dto);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable String userId) {
		User user = new User();
		user=userservice.getUsersByUserId(userId);
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping(value="/user/{userId}",produces = "application/json")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User userDetails) {
		User user=new User();
		user=userservice.getUsersByUserId(userId);
		user.setUserName(userDetails.getUserName());
		user.setUserEmail(userDetails.getUserEmail());
		user.setUserPassword(userDetails.getUserPassword());
		user.setUserConfirmpassword(userDetails.getUserConfirmpassword());
		user.setUserRole(userDetails.getUserRole());
		User updateUser=userservice.update(user, userId);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String userId) {

		userservice.delete(userId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
