package com.obvious.notes.Contract;

public interface NotesDetailsActivityContract {
    interface View{
        void initView();
    }

    interface Model{
    }

    interface Presenter{
        void onClick(android.view.View view);
    }
}
