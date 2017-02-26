package com.shivajivarma.user.service;

import com.shivajivarma.user.model.User;

public interface AppUserService {
    User loadUserByUsername(String username);

    Long post(User appUser);

    User get(Long id);

    User patch(User appUser);

    boolean delete(Long id);
}
