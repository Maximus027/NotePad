package c4q.notepad.recyclerhelpers;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import c4q.notepad.FinishedNoteListener;
import c4q.notepad.NoteDialogFragment;
import c4q.notepad.R;
import c4q.notepad.model.Note;
import io.realm.Realm;

/**
 * Created by maxrosado on 7/16/17.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private static final String NOTE_DIALOG = "NoteDialog";

    @BindView(R.id.title_tv)
    TextView titleTV;

    @BindView(R.id.text_tv)
    TextView textTV;

    @BindView(R.id.delete_button)
    Button deleteButton;

    public NoteViewHolder(View parent) {
        super(parent);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Note note, final FinishedNoteListener listener) {
        textTV.setText(note.getText());
        titleTV.setText(note.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNote(note, listener);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                note.deleteFromRealm();
                realm.commitTransaction();

                listener.updateUI();
            }
        });
    }

    private void editNote (Note note, FinishedNoteListener listener) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("note", note);

        FragmentManager fm = ((AppCompatActivity) itemView.getContext()).getSupportFragmentManager();
        NoteDialogFragment noteDialogFragment = new NoteDialogFragment();
        noteDialogFragment.setfinishedNoteListener(listener);
        noteDialogFragment.setArguments(bundle);
        noteDialogFragment.show(fm, NOTE_DIALOG);
    }


}
