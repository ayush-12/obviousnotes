package com.obvious.notes.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.obvious.notes.Contract.NotesListActivityContract;
import com.obvious.notes.Presenter.NotesListActivityPresenter;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.View.NotesListActivity;

import java.util.List;

public class NotesListActivityModel implements NotesListActivityContract.Model{

    private static final String TAG="ListModel";

    private Context mContext;
    private NotesListActivityPresenter mPresenter;

    public NotesListActivityModel(Context mContext, NotesListActivityPresenter notesListActivityPresenter) {
        mContext=mContext;
        mPresenter=notesListActivityPresenter;
    }

    @Override
    public void getNotesFromDB() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Notes> notes = NotesListActivity.notesDatabase.notesDAO().getAllData();
                Log.d(TAG, "run: notes size "+notes.size());
                if(notes.size()==0){
                    // some message
                    mPresenter.callViewToSetViewForNoNotes();
                }
                else {
                    // call presenter to set the notes adapter
                    mPresenter.callViewToSetAdapterWithNotes(notes);
                }
                mPresenter.callViewToHideProgressBar();
            }
        });
    }
}
