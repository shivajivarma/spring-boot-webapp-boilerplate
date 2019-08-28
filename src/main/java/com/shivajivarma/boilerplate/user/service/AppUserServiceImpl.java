package com.shivajivarma.boilerplate.user.service;

import com.shivajivarma.boilerplate.user.model.User;
import com.shivajivarma.boilerplate.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "appUserService")
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long post(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User patch(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
