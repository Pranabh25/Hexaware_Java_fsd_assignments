package com.ecom.logistics.service;

import com.ecom.logistics.model.User;
import com.ecom.logistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all non-deleted users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Save or update a user
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Hard delete a user by ID
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    // Soft delete a user by ID
    public void softDeleteUser(Long id) {
        userRepository.delete(id);
    }

	public boolean verifyLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
