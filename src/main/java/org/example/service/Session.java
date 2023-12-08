package org.example.service;

import org.example.domain.User;

public interface Session {
    User unwrap();

    class MockSession implements Session{

        @Override
        public User unwrap() {
            return null;
        }
    }

}
