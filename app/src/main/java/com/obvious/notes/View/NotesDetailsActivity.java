package com.obvious.notes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.obvious.notes.Contract.NotesDetailsActivityContract;
import com.obvious.notes.Presenter.NotesDetailsActivityPresenter;
import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;

public class NotesDetailsActivity extends AppCompatActivity implements NotesDetailsActivityContract.View {

    private static final String TAG ="DetailsActivity";

    private NotesDetailsActivityPresenter mPresenter;


    private TextView createdDateTextView;
    private TextView titleTextView;
    private TextView contentTextView;

    private String createdDate;
    private String title;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);

        mPresenter=new NotesDetailsActivityPresenter(this,this);


        Notes note = getIntent().getParcelableExtra("note");
        createdDate=note.getNoteCreatedDate();
        title=note.getNoteTitle();
        content=note.getNoteContent();
        Log.d(TAG, "onCreate: created date "+createdDate+ " title "+title);

        createdDateTextView.setText(createdDate);
        titleTextView.setText(title);
        contentTextView.setText(content);
    }

    @Override
    public void initView() {
        createdDateTextView = findViewById(R.id.created_date_text_view);
        titleTextView= findViewById(R.id.heading_title_text_view);
        contentTextView=findViewById(R.id.content_details_text_view);

    }
}
