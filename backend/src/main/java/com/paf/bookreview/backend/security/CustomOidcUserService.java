package com.paf.bookreview.backend.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paf.bookreview.backend.model.Role;
import com.paf.bookreview.backend.model.User;
import com.paf.bookreview.backend.repository.UserRepository;

@Service
public class CustomOidcUserService extends OidcUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public OidcUser loadUser(OidcUserRequest userRequest) {
        OidcUser oidcUser = super.loadUser(userRequest);

        String email = oidcUser.getEmail();
        String name = oidcUser.getFullName();

        Optional<User> existingUser = userRepository.findByEmail(email);

        User user;

        if (existingUser.isEmpty()) {
            // New user - assign the default role
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setUsername(email.split("@")[0]);

            // Assign default role based on email
            if (email.equals("tathienbao.ttb@gmail.com")) {
                user.setRole(Role.ADMIN);  // Assigning admin role
            } else {
                user.setRole(Role.REVIEWER);  // Default role
            }

            userRepository.save(user);
        } else {
            // Existing user - just log the role
            user = existingUser.get();
            user.setName(name);
            userRepository.save(user);
        }

        // Log the role
        System.out.println("User " + user.getUsername() + " has role: " + user.getRole());

        return oidcUser;
    }
}
