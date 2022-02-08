package com.user.management.usermanagement.service;

import java.util.List;
import com.user.management.usermanagement.model.User;

public interface UserService {
	
	List<User> findAll ();
	void save (User user);

}
