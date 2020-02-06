package com.obvious.notes.Presenter;

import android.content.Context;

import com.obvious.notes.Contract.NotesDetailsActivityContract;
import com.obvious.notes.Model.NotesDetailsActivityModel;

public class NotesDetailsActivityPresenter implements NotesDetailsActivityContract.Presenter {

    private final String TAG = "DetailsPresenter";
    private NotesDetailsActivityContract.View mView;
    private Context mContext;
    private NotesDetailsActivityContract.Model model;


    public NotesDetailsActivityPresenter(NotesDetailsActivityContract.View view, Context context){
        mView=view;
        mContext=context;
        initPresenter();
    }

    private void initPresenter(){
        model= new NotesDetailsActivityModel(mContext,this);
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view) {

    }

}
