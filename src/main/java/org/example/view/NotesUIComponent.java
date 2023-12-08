package org.example.view;

import org.example.data.NoteRepository;
import org.example.domain.Note;
import org.example.domain.User;
import org.example.service.Session;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class NotesUIComponent implements UIComponent {

    private final NoteRepository noteRepository;

    public NotesUIComponent(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Session render(Session session) {

        User user = session.unwrap();
        showNotes(noteRepository.findNotesByUser(user.getUserName()));
        int code = getConfirmation();
        if(code==0){
            noteRepository.save(new Note(user.getUserName(), JOptionPane.showInputDialog("New Note:")));
            showNotes(noteRepository.findNotesByUser(user.getUserName()));
        }



        return session;
    }

    private static int getConfirmation() {
        return JOptionPane.showConfirmDialog(
                null,
                "Any new Notes?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private void showNotes(List<Note> notes) {

        String notesAsString = notes.stream().map(Note::getNote).collect(Collectors.joining(","));

        JOptionPane.showMessageDialog(
                null,
                notesAsString,
                "Current Notes",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
