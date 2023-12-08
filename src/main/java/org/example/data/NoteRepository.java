package org.example.data;

import org.example.domain.Note;

import java.util.*;

public interface NoteRepository {

    List<Note> findNotesByUser(String userName);

    void save(Note note);


    class MockNoteRepository implements NoteRepository {

        private static final List<Note> mockNotes = new ArrayList<>(
                List.of(
                        new Note("dima", "Note 1"),
                        new Note("dima", "Note 2")
                )
        );

        @Override
        public List<Note> findNotesByUser(String userName) {
            if ("dima".equals(userName)) {
                return mockNotes;
            } else {
                return Collections.emptyList();
            }
        }

        @Override
        public void save(Note note) {
            if("dima".equals(note.getUserName())){
                mockNotes.add(note);
            }
        }
    }


}
