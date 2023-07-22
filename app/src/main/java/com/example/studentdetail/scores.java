package com.example.studentdetail;

import com.google.gson.annotations.SerializedName;

public class scores {
    @SerializedName("score")
    private double Score;
    @SerializedName("type")
    private String Type;

    public scores(double score, String type) {
        Score = score;
        Type = type;
    }

    public double getScore() {
        return Score;
    }

    public String getType() {
        return Type;
    }

    public void setScore(double score) {
        Score = score;
    }

    public void setType(String type) {
        Type = type;
    }
}
