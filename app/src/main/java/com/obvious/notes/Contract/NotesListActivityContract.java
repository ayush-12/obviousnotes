package com.obvious.notes.Contract;

import com.obvious.notes.SqlLiteDb.Notes;

import java.util.List;

public interface NotesListActivityContract {
    interface View{
        void initView();

        void setViewsForNoNotes();
        void setViewForNotesList(List<Notes> notes);
        void hideProgressBar();
        void showProgressBar();
    }

    interface Model{
        void getNotesFromDB();
    }

    interface Presenter{
        void onClick(android.view.View view);
        void goToCreateNoteActivity();

        void callModelToGetNotes();

        void callViewToSetViewForNoNotes();
        void callViewToSetAdapterWithNotes(List<Notes> notes);
        void callViewToHideProgressBar();
    }
}
