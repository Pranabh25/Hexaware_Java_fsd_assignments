package com.ecom.logistics.repository;

import com.ecom.logistics.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsernameAndPassword(String username, String password);

	List<User> findAll();

	User findById(Long id);

	void delete(Long id);

	void save(User user);

}

