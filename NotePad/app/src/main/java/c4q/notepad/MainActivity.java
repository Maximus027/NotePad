package c4q.notepad;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import c4q.notepad.model.Note;
import c4q.notepad.recyclerhelpers.NoteAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements FinishedNoteListener {

    private static final String NOTE_DIALOG = "NoteDialog";
    private static final String TAG = MainActivity.class.getName(); // For logs.

    @BindView(R.id.notes_rv) RecyclerView noteRecyclerView;
    @BindView(R.id.fab) FloatingActionButton floationgActionButton;

    private NoteAdapter noteAdapter;
    private RealmResults<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Realm.init(this); // Initializing Realm Database

        notes = Realm.getDefaultInstance().where(Note.class).findAll();
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(notes, this);
        noteRecyclerView.setAdapter(noteAdapter);
    }

    @OnClick(R.id.fab) // Set the Floating Action Button onClickListener here with Butterknife
    public void showNoteDialog() {
        FragmentManager manager = getSupportFragmentManager();
        NoteDialogFragment noteDialogFragment = new NoteDialogFragment();
        noteDialogFragment.setfinishedNoteListener(this);
        noteDialogFragment.show(manager, NOTE_DIALOG);
    }

    @Override
    public void updateUI() {
        noteAdapter.notifyDataSetChanged();
    }
}

