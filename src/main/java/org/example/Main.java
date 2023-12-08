package org.example;

import org.example.data.FileUserRepository;
import org.example.data.NoteRepository;
import org.example.data.UserRepository;
import org.example.service.Session;
import org.example.view.LoginUIComponent;
import org.example.view.NotesUIComponent;
import org.example.view.UIComponents;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        new UIComponents(new LoginUIComponent(
                new FileUserRepository(Path.of("users.csv"))),
                new NotesUIComponent(new NoteRepository.MockNoteRepository())
        ).render(
                new Session.MockSession()
        );
    }
}