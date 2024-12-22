package com.santu.services.interfac;

import com.santu.dto.request.SignupRequest;
import com.santu.entities.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);
}
