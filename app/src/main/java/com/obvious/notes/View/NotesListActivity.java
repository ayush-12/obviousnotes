package com.obvious.notes.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.obvious.notes.Adapters.NotesAdapter;
import com.obvious.notes.Contract.NotesListActivityContract;
import com.obvious.notes.Presenter.NotesListActivityPresenter;
import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.SqlLiteDb.NotesDatabase;

import java.util.Collections;
import java.util.List;

public class NotesListActivity extends AppCompatActivity implements NotesListActivityContract.View {

    private static final String TAG="ListActivity";

    private NotesListActivityPresenter mPresenter;

    private FloatingActionButton createNewNoteButton;
    private RecyclerView notesRecyclerView;
    private TextView noNotesTextView;
    private ProgressBar progressBar;

    private NotesAdapter notesAdapter;

    public static NotesDatabase notesDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        mPresenter = new NotesListActivityPresenter(this, this);

        notesDatabase = Room.databaseBuilder(this, NotesDatabase.class, "Notes").build();

        showProgressBar();
    }

    @Override
    public void initView() {
        createNewNoteButton = findViewById(R.id.create_note_button);
        createNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(view);
            }
        });

        notesRecyclerView = findViewById(R.id.notes_list_recycler_view);
        notesRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(linearLayoutManager);

        noNotesTextView = findViewById(R.id.no_notes_text_view);
        progressBar =  findViewById(R.id.progress_bar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.callModelToGetNotes();

    }

    @Override
    public void setViewsForNoNotes() {
        notesRecyclerView.setVisibility(View.INVISIBLE);
        noNotesTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setViewForNotesList(List<Notes> notes) {
        Log.d(TAG, "setViewForNotesList: notes setting adapter "+notes.size());
        noNotesTextView.setVisibility(View.INVISIBLE);
        notesRecyclerView.setVisibility(View.VISIBLE);
        Collections.reverse(notes);
        notesAdapter = new NotesAdapter(this, notes);
        notesRecyclerView.setAdapter(notesAdapter);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
