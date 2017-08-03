package c4q.notepad.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by maxrosado on 7/16/17.
 */

public class Note extends RealmObject implements Serializable {

    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
