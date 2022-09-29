package com.maven.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maven.student.dto.User;

public interface UserRepository extends JpaRepository<User,String> {

	@Query(value="select * from user where user_id=:id or user_name=:name",nativeQuery = true)
    List<User> searchUser(@Param("id") String userid, @Param("name") String username);
	
	User findByUserId(String userId);

}
