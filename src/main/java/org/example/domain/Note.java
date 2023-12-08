package org.example.domain;

public class Note {

    private final String userName;

    private final String note;


    public Note(String userName, String note) {
        this.userName = userName;
        this.note = note;
    }

    public String getUserName() {
        return userName;
    }

    public String getNote() {
        return note;
    }
}
