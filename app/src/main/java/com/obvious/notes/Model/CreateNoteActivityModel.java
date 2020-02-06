package com.obvious.notes.Model;

import android.content.Context;
import android.os.AsyncTask;

import com.obvious.notes.Contract.CreateNoteActivityContract;
import com.obvious.notes.Presenter.CreateNoteActivityPresenter;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.View.NotesListActivity;

public class CreateNoteActivityModel implements CreateNoteActivityContract.Model {

    private static final String TAG="CreateModel";

    private Context mContext;
    private CreateNoteActivityPresenter mPresenter;

    public CreateNoteActivityModel(Context mContext, CreateNoteActivityPresenter createNoteActivityPresenter) {
        this.mContext=mContext;
        this.mPresenter=createNoteActivityPresenter;
    }

    @Override
    public void addNoteToDB(final Notes note) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                NotesListActivity.notesDatabase.notesDAO().addNoteToDB(note);
            }
        });
    }
}
