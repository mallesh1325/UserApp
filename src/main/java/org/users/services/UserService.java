package org.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.users.dto.AuthRequestDto;
import org.users.entity.User;
import org.users.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void register(AuthRequestDto authRequestDto) {
		User user = new User();
		user.setUsername(authRequestDto.getUsername());
		user.setEmail(authRequestDto.getEmail());
		user.setPassword(passwordEncoder.encode(authRequestDto.getPassword()));
		userRepository.save(user);
	}

	public String deleteUserById(Integer id) {
		Optional<User> existingUser = userRepository.findById(id);

		if (existingUser.isPresent()) {
			userRepository.deleteById(id);
			return "User with ID " + id + " deleted successfully.";
		} else {
			return "User with ID " + id + " not found.";
		}
	}
}
