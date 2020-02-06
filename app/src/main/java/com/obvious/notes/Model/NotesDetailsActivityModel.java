package com.obvious.notes.Model;

import android.content.Context;
import android.widget.TextView;

import com.obvious.notes.Contract.NotesDetailsActivityContract;
import com.obvious.notes.Presenter.NotesDetailsActivityPresenter;

public class NotesDetailsActivityModel implements NotesDetailsActivityContract.Model {

    private static final String TAG= "DetailsModel";
    private Context mContext;
    private NotesDetailsActivityPresenter mPresenter;


    public NotesDetailsActivityModel(Context mContext, NotesDetailsActivityPresenter notesDetailsActivityPresenter) {
        this.mContext=mContext;
        mPresenter=notesDetailsActivityPresenter;

    }
}
