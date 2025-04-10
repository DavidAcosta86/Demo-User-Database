package com.login.Demo.User.Database.Services;

import com.login.Demo.User.Database.Entities.User;
import com.login.Demo.User.Database.Entities.Role;
import com.login.Demo.User.Database.Repositories.UserRepository;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processOAuth2User(OAuth2AuthenticationToken token) {
        OAuth2User oauth2User = token.getPrincipal();
        Map<String, Object> attributes = oauth2User.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String pictureUrl = (String) attributes.get("picture");

        userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = User.builder()
                    .userName(name)
                    .email(email)
                    .userRole(Role.USER) // o lo que necesites por defecto
                    .profilePicUrl(pictureUrl)
                    .isActive(true)
                    .build();
            return userRepository.save(newUser);
        });
    }
}