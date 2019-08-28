package com.shivajivarma.boilerplate.user.service;

import com.shivajivarma.boilerplate.user.model.User;

import java.util.Optional;

public interface AppUserService {
    User loadUserByUsername(String username);

    Long post(User appUser);

    Optional<User> get(Long id);

    User patch(User appUser);

    boolean delete(Long id);
}
