package com.obvious.notes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.obvious.notes.Contract.CreateNoteActivityContract;
import com.obvious.notes.DialogBox.NoteNotSaved;
import com.obvious.notes.Presenter.CreateNoteActivityPresenter;
import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNoteActivity extends AppCompatActivity implements CreateNoteActivityContract.View {

    private static final String TAG="CreateActivity";

    private CreateNoteActivityPresenter mPresenter;

    private FloatingActionButton saveNoteButton;
    private EditText titleEditText;
    private EditText contentEditText;

    private Notes newNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        mPresenter=new CreateNoteActivityPresenter(this,this);
        newNote= new Notes();
        newNote.setNoteCreatedDate(getDateAndTime());

    }

    @Override
    public void initView() {
        saveNoteButton = findViewById(R.id.save_button);
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(view);
            }
        });

        titleEditText = findViewById(R.id.title_edit_text);
        contentEditText = findViewById(R.id.notes_content_edit_text);

    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void callOnClickToSaveNote() {
        mPresenter.onClick(saveNoteButton);
    }

    @Override
    public void goBack() {
        super.onBackPressed();
    }

    @Override
    public boolean checkForIfFieldsAreEmpty() {
        if(titleEditText.getText().toString().length()<1){
            titleEditText.setError("Cannot be empty");
            return false;
        }
        else if(contentEditText.getText().toString().length()<1){
            contentEditText.setError("Cannot be empty");
            return false;
        }
        else {
            newNote.setNoteContent(contentEditText.getText().toString());
            newNote.setNoteTitle(titleEditText.getText().toString());
            return true;
        }
    }


    @Override
    public Notes getNotes() {
        return newNote;
    }

    @Override
    public void onBackPressed() {
        if(checkForIfFieldsAreEmpty()){
            NoteNotSaved noteNotSaved = new NoteNotSaved(CreateNoteActivity.this,this);
            noteNotSaved.generateDialogBox();
        }
        else {
            super.onBackPressed();
        }
    }

    private String getDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm");
        Date date = new Date();
        String dateAndTime = dateFormat.format(date);
        return dateAndTime;
    }


}
