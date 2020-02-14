package com.example.googlekeepclone;

import java.util.UUID;

public class Note {

    private String head;
    private String text;
    private String color;
    private UUID id;

    public Note(String head, String text, String color){
        id = UUID.randomUUID();
        this.head= head;
        this.text = text;
        this.color = color;
    }

    public Note() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHead() {
        return this.head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}