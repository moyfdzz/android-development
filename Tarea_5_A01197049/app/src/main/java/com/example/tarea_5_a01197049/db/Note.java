package com.example.tarea_5_a01197049.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Note")

public class Note {

    @PrimaryKey(autoGenerate = true)
    private long noteId;
    private String content;

    public Note(String content) {
        this.content = content;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
