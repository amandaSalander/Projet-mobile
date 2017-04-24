package model;

/**
 * Created by amanda on 17/04/17.
 */

public class Commentaire {
    private String content;
    private int note;

    public Commentaire(String content, int note) {
        this.content = content;
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
