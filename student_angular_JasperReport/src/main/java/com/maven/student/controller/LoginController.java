package com.maven.student.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maven.student.dao.UserService;
import com.maven.student.dto.User;
import com.maven.student.model.LoginBean;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("loginBean")
	public LoginBean getLoginBean() {
		return new LoginBean();
	}

	@PostMapping(value ="/login", produces = "application/json")
	public ResponseEntity<User> login(@RequestBody  User user ) {

		User userLogin = userService.getUsersByUserId(user.getUserId());
		
		List<User> list=userService.getAllUsers();
			if(list != null) {
				if(userLogin.getUserPassword().equals(user.getUserPassword())) {
					return ResponseEntity.ok(userLogin);
			
				}else if(userLogin.getUserId().equals("") || userLogin.getUserPassword().equals("")){
					return (ResponseEntity<User>) ResponseEntity.internalServerError();
			}
		}
		return (ResponseEntity<User>) ResponseEntity.internalServerError();
		
	}
		
	}
	
//	@RequestMapping(value="/login" , method = RequestMethod.POST)
//	public String login(ModelMap model, @RequestParam("userId") String userId, @RequestParam("userPassword") String userPassword, HttpSession session) {
//		List<User> list=user.getAllUsers();
//		if(list != null) {			
//			for(User user: list) {
//				if( user.getUserId().equals(userId) &&
//						 user.getUserPassword().equals(userPassword)) {
//				       session.setAttribute("user", user.getUserId()+","+user.getUserName());
//					       session.setAttribute("time",LocalDateTime.now());
//						   return "MNU001";
//				}
//			}
//		}		
//		model.addAttribute("error", "Please check your data again! ");
//		return "LGN001";		
//	}
//	
//	@RequestMapping(value="/logout" , method = RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.setAttribute("user","");		
//		session.invalidate();
//		return "LGN001";
//	}
//}
