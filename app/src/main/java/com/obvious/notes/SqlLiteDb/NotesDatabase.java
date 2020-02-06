package com.obvious.notes.SqlLiteDb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDAO notesDAO();
}
