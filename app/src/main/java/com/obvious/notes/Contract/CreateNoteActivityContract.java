package com.obvious.notes.Contract;

import com.obvious.notes.SqlLiteDb.Notes;

public interface CreateNoteActivityContract {
    interface View{
        void initView();
        void finishActivity();
        void callOnClickToSaveNote();
        void goBack();

        boolean checkForIfFieldsAreEmpty();

        Notes getNotes();
    }

    interface Model{
        void addNoteToDB(Notes note);
    }

    interface Presenter{
        void onClick(android.view.View view);
        void goToNotesDetailsActivity();

    }


}
