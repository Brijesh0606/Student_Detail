package com.example.studentdetail;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class detail_of_student extends AppCompatActivity {

    TextView student_id, student_name, exam_score, home_score, quiz_score;
    ImageView student_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_student);

        student_id = findViewById(R.id.student_id);
        student_name = findViewById(R.id.student_name);
        exam_score = findViewById(R.id.exam_score);
        home_score = findViewById(R.id.homework_score);
        quiz_score = findViewById(R.id.quiz_score);
        student_image = findViewById(R.id.student_image);

        String s_id = String.valueOf(getIntent().getIntExtra("id", 0));
        String s_name = getIntent().getStringExtra("name");
        String e_score = String.valueOf(getIntent().getDoubleExtra("exam_score", 0.0d));
        String h_score = String.valueOf(getIntent().getDoubleExtra("home_score", 0.0d));
        String q_score = String.valueOf(getIntent().getDoubleExtra("quiz_score", 0.0d));

        student_id.setText(s_id);
        student_name.setText(s_name);
        exam_score.setText(e_score);
        home_score.setText(h_score);
        quiz_score.setText(q_score);

        String Image_name = "s"+s_id+".png";

        AssetManager assetManager = getAssets();
        try {
            InputStream i = assetManager.open("Student_Images/"+Image_name);
            Bitmap bitmap = BitmapFactory.decodeStream(i);
            student_image.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}