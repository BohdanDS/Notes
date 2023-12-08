package org.example.view;

import org.example.data.UserRepository;
import org.example.domain.User;
import org.example.service.Session;
import org.example.service.UserSession;

import javax.swing.*;
import java.util.Optional;

public class LoginUIComponent implements UIComponent {

    private final UserRepository userRepository;


    public LoginUIComponent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Session render(Session session) {

        String userName = JOptionPane.showInputDialog("Login:");
        String password = JOptionPane.showInputDialog("Password:");

        Optional<User> byUserName = userRepository.findByUserName(userName);
        if (byUserName.isPresent()){
            User user = byUserName.get();
            if (user.getPassword().equals(password)){
                return new UserSession(user);
            }
        }

        showError();
        return render(session);
    }

    private void showError() {
        JOptionPane.showMessageDialog(
                null,
                "Bad Credentials",
                "Error Message",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
