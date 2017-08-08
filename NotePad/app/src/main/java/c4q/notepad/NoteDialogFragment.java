package c4q.notepad;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

import c4q.notepad.model.Note;

import io.realm.Realm;

/**
 * This is the class that houses the dialog fragment for creating new notes and editing existing
 * notes.
 */

public class NoteDialogFragment extends android.support.v4.app.DialogFragment {

    private static final String NOTE_KEY = "note";

    private FinishedNoteListener listener;
    private Note note = null;

    @BindString(R.string.dialog_new_note)
    String dialogTitle;

    @BindView(R.id.new_note_title_input)
    EditText titleEditText;

    @BindView(R.id.new_note_text_body_input)
    EditText noteEditText;

    public void setfinishedNoteListener(FinishedNoteListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.note_dialog, null);

        ButterKnife.bind(this, v);

        Bundle bundle = getArguments();
        if (bundle != null) {
            // key / values
            dialogTitle = getString(R.string.dialog_edit_note);
            note = (Note) getArguments().getSerializable(NOTE_KEY);
            String savedTitle = note.getTitle();
            String savedText = note.getText();

            if (!savedTitle.isEmpty() && !savedText.isEmpty()) {
                titleEditText.setText(savedTitle);
                noteEditText.setText(savedText);
            }
        }


        return getAlertDialog(v, titleEditText, noteEditText);
    }

    private AlertDialog getAlertDialog(final View v, final EditText titleed, final EditText noteed) {
        final AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(dialogTitle)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String titleText = String.valueOf(titleed.getText());
                        String noteText = String.valueOf(noteed.getText());

                        if (!noteText.equals("") && !titleText.equals("")) {

                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();

                            if (note == null) {
                                note = realm.createObject(Note.class);
                            }

                            note.setTitle(titleText);
                            note.setText(noteText);

                            realm.insertOrUpdate(note);
                            realm.commitTransaction();
                            listener.updateUI();
                        } else {
                            Toast.makeText(v.getContext(), "Must have a title and a note to save.", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.black));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.black));
            }
        });
        return alertDialog;
    }

}
