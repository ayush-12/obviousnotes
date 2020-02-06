package com.obvious.notes.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import com.obvious.notes.Contract.NotesListActivityContract;
import com.obvious.notes.Model.NotesListActivityModel;
import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.View.CreateNoteActivity;
import com.obvious.notes.View.NotesListActivity;

import java.util.List;
import java.util.logging.Handler;

public class NotesListActivityPresenter implements NotesListActivityContract.Presenter {

    private final String TAG = "NotesListPresenter";
    private NotesListActivityContract.View mView;
    private Context mContext;
    private NotesListActivityContract.Model model;


    public NotesListActivityPresenter(NotesListActivityContract.View view, Context context){
        mView=view;
        mContext=context;
        initPresenter();
    }

    private void initPresenter(){
        model= new NotesListActivityModel(mContext,this);
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view) {
        if(view.getId()== R.id.create_note_button){
            goToCreateNoteActivity();
        }
    }

    @Override
    public void goToCreateNoteActivity() {
        Intent intent = new Intent(mContext, CreateNoteActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void callModelToGetNotes() {
        model.getNotesFromDB();
    }

    @Override
    public void callViewToSetViewForNoNotes() {
        mView.setViewsForNoNotes();
    }

    @Override
    public void callViewToSetAdapterWithNotes(final List<Notes> notes) {
        ((NotesListActivity) mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mView.setViewForNotesList(notes);
            }
        });
    }

    @Override
    public void callViewToHideProgressBar() {
        mView.hideProgressBar();
    }

}
