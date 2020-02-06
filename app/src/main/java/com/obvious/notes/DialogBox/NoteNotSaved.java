package com.obvious.notes.DialogBox;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.obvious.notes.Contract.CreateNoteActivityContract;
import com.obvious.notes.View.CreateNoteActivity;

public class NoteNotSaved {

    private Context mContext;
    private CreateNoteActivityContract.View mView;

    public NoteNotSaved(Context context, CreateNoteActivityContract.View view){
        this.mContext=context;
        mView=view;
    }


    public void generateDialogBox() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Save Note?!!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mView.callOnClickToSaveNote();
            }

        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mView.goBack();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();
    }
}
