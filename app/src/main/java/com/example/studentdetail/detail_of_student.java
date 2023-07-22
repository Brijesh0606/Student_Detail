package com.example.studentdetail;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        int id = getIntent().getIntExtra("id", 0);

        String s_name = getIntent().getStringExtra("name");
        String e_score = String.valueOf(getIntent().getDoubleExtra("exam_score", 0.0d));
        String h_score = String.valueOf(getIntent().getDoubleExtra("home_score", 0.0d));
        String q_score = String.valueOf(getIntent().getDoubleExtra("quiz_score", 0.0d));

//        DecimalFormat df = new DecimalFormat("000000");
//        String formattedId = df.format(id);


        student_id.setText(s_id);
        student_name.setText(s_name);
        exam_score.setText(e_score);
        home_score.setText(h_score);
        quiz_score.setText(q_score);

        String Folder_Id = "1TCXA8qIEHxoDhcpARlUFBIuJH3AQ-v2t";

//        String fileinJSON;
//
//        MyAsyncTask task = new MyAsyncTask();
//        task.execute("https://drive.google.com/drive/folders/1TCXA8qIEHxoDhcpARlUFBIuJH3AQ-v2t");


    }

//    public class MyAsyncTask extends AsyncTask<String,Void,Bitmap>{
//
//
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//            OkHttpClient client = new OkHttpClient();
//
//            String url = strings[0];
//            Request request = new Request.Builder()
//                    .url(url)
//                    .build();
//
//            try {
//                Response response = client.newCall(request).execute();
//
//                String fileinJSON = response.body().string();
//
//                Log.d("data",fileinJSON);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return null;
//        }
//    }

}