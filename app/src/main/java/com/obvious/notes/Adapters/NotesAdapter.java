package com.obvious.notes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.obvious.notes.R;
import com.obvious.notes.SqlLiteDb.Notes;
import com.obvious.notes.View.NotesDetailsActivity;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private static final String TAG="NotesAdapter";
    private Context mContext;
    private List<Notes> notes;


    public NotesAdapter(Context context,List<Notes> notes)
    {
        mContext=context;
        this.notes=notes;
    }



    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.note_list_view,parent,false);
        return new NotesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: adapter notes setting "+notes.size());
        Notes note = notes.get(position);
        holder.note=note;
        holder.titleTextView.setText(note.getNoteTitle());
        holder.dateTextView.setText(note.getNoteCreatedDate());
        holder.contentTextView.setText(note.getNoteContent());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView dateTextView;
        TextView contentTextView;

        Notes note;

        public NotesViewHolder(View view){
            super(view);
            titleTextView = view.findViewById(R.id.title_text_view);
            dateTextView = view.findViewById(R.id.date_text_view);
            contentTextView=view.findViewById(R.id.content_text_view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, NotesDetailsActivity.class);
                    intent.putExtra("note",note);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
