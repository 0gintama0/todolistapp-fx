package dev.jeici.service;


import dev.jeici.entities.User;

public interface UserService extends GenericService<User> {

	boolean authenticate(String email, String password);

	User findByEmail(String email);

}