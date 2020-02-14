package com.example.googlekeepclone;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteLab {
    private static NoteLab sCrimeLab;
    private List<Note> mNotes;
    public static NoteLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new NoteLab(context);
        }
        return sCrimeLab;
    }
    private NoteLab(Context context) {
        mNotes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Note note = new Note();
            note.setHead("Note #" + i);
            note.setText("TextTextText #" + i);
            note.setColor("#FGHJHGf #" + i);
            mNotes.add(note);
        }
    }
    public List<Note> getNotes() {
        return mNotes;
    }
    public Note getNote(UUID id) {
        for (Note note : mNotes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }
}