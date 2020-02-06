package com.obvious.notes.SqlLiteDb;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes")
public class Notes implements Parcelable {

    @NonNull @PrimaryKey(autoGenerate = true)
    private int uniqueId;

    @NonNull
    private String noteTitle;
    @NonNull
    private String noteContent;
    @NonNull
    private String noteCreatedDate;

    public Notes(){}

    public Notes(Notes note){
        this.noteCreatedDate=note.getNoteCreatedDate();
        this.noteContent=note.getNoteContent();
        this.noteTitle=note.getNoteTitle();
    }

    protected Notes(Parcel in) {

        noteTitle = in.readString();
        noteContent  = in.readString();
        noteCreatedDate = in.readString();

    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteCreatedDate() {
        return noteCreatedDate;
    }

    public void setNoteCreatedDate(String noteCreatedDate) {
        this.noteCreatedDate = noteCreatedDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(noteTitle);
        parcel.writeString(noteContent);
        parcel.writeString(noteCreatedDate);
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public static Creator<Notes> getCREATOR() {
        return CREATOR;
    }

}
