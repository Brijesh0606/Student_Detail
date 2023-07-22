package com.example.studentdetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {

    @SerializedName("_id")
    private int id;
    @SerializedName("name")
    private String Name;

    @SerializedName("scores")
    private scores[] Scores;

    public Student(int id, String name, scores[] scores) {
        this.id = id;
        Name = name;
        Scores = scores;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public scores[] getScores() {
        return Scores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScores(scores[] scores) {
        Scores = scores;
    }

}
