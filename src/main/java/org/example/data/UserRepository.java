package org.example.data;

import org.example.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserName(String userName);


    class MockUserRepository implements UserRepository {

        @Override
        public Optional<User> findByUserName(String userName) {

            if ("dima".equals(userName)) {
                return Optional.of(
                        new User(
                                "dima",
                                "12345"
                        ));
            }
            else {
                return Optional.empty();
            }

        }
    }


}
