package com.obvious.notes.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.BundleCompat;

import com.obvious.notes.Contract.CreateNoteActivityContract;
import com.obvious.notes.Model.CreateNoteActivityModel;
import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.View.NotesDetailsActivity;

public class CreateNoteActivityPresenter implements CreateNoteActivityContract.Presenter {

    private final String TAG = "CreatePresenter";
    private CreateNoteActivityContract.View mView;
    private Context mContext;
    private CreateNoteActivityContract.Model model;


    public CreateNoteActivityPresenter(CreateNoteActivityContract.View view, Context context){
        mView=view;
        mContext=context;
        initPresenter();
    }

    private void initPresenter(){
        model= new CreateNoteActivityModel(mContext,this);
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view) {
        if(view.getId()== R.id.save_button){
            if(mView.checkForIfFieldsAreEmpty()) {
                model.addNoteToDB(mView.getNotes());
                goToNotesDetailsActivity();
            }
        }
    }

    @Override
    public void goToNotesDetailsActivity() {
        Intent intent = new Intent(mContext, NotesDetailsActivity.class);
        Notes note =  new Notes(mView.getNotes());
        intent.putExtra("note",note);
        mContext.startActivity(intent);
        mView.finishActivity();
    }
}
