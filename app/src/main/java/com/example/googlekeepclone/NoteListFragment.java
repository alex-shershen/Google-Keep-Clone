package com.example.googlekeepclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListFragment extends Fragment {
    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_list_fragment, container,
                false);
        mNoteRecyclerView = (RecyclerView) view
                .findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));
        updateUI();
        return view;
    }
    private void updateUI() {
        NoteLab crimeLab = NoteLab.get(getActivity());
        List<Note> crimes = crimeLab.getNotes();
        mAdapter = new NoteAdapter(crimes);
        mNoteRecyclerView.setAdapter(mAdapter);
    }
    private class NoteHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private Note mNote;
        private TextView mHeadTextView;
        private TextView mTextTextView;
        public NoteHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_note, parent, false));
            itemView.setOnClickListener(this);
            mHeadTextView = (TextView) itemView.findViewById(R.id.note_head);
            mTextTextView = (TextView) itemView.findViewById(R.id.note_text);
        }
        public void bind(Note note) {
            mNote = note;
            mHeadTextView.setText(mNote.getHead());
            mTextTextView.setText(mNote.getText());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mNote.getHead() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {
        private List<Note> mNotes;
        public NoteAdapter(List<Note> notes) {
            mNotes = notes;
        }

        @NonNull
        @Override
        public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new NoteHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
            Note note = mNotes.get(position);
            holder.bind(note);
        }
        @Override
        public int getItemCount() {
            return mNotes.size();
        }
    }
}