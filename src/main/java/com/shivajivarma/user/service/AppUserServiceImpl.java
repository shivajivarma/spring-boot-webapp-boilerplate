package com.shivajivarma.user.service;

import com.shivajivarma.user.model.User;
import com.shivajivarma.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public User get(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User patch(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        userRepository.delete(id);
        return true;
    }
}
