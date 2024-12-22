package com.santu.services.impl;


import com.santu.dto.request.SignupRequest;
import com.santu.entities.User;
import com.santu.repository.UserRepository;
import com.santu.services.interfac.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        BeanUtils.copyProperties(signUpRequest, user);

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        user.setPassword(hashedPassword);
        User createUser = userRepository.save(user);
        user.setId(createUser.getId());

        return user;
    }
}
