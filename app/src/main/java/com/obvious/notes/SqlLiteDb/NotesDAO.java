package com.obvious.notes.SqlLiteDb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDAO {

    @Insert
    void addNoteToDB(Notes note);

    @Query("SELECT * FROM notes ")
    public List<Notes> getAllData();

}

