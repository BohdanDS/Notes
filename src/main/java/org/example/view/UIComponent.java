package org.example.view;

import org.example.service.Session;

import javax.swing.*;

public interface UIComponent {

    Session render(Session session);

    class MockUIComponent implements UIComponent {

        @Override
        public Session render(Session session) {
            JOptionPane.showMessageDialog(
                    null,
                    "I am Mock UI component",
                    "Mock Message",
                    JOptionPane.INFORMATION_MESSAGE);
            return session;
        }
    }
}
