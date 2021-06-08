package com.example.tarea_5_a01197049.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDAO {

    @Query("Select * from Note")
    List<Note> AllNotes();

    @Query("Select * from Note where content = :content")
    List<Note> SearchByContent(String content);

    @Insert
    Long insertNote(Note note);

    @Update
    int updateNote(Note note);

    @Delete
    int deleteNote(Note note);
}
