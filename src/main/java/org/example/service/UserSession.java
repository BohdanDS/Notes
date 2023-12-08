package org.example.service;

import org.example.domain.User;

public class UserSession implements Session{

    private final User user;

    public UserSession(User user) {
        this.user = user;
    }

    @Override
    public User unwrap() {
        return user;
    }
}
