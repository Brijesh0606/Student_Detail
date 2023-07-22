package com.example.studentdetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homework#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homework extends Fragment implements SelectListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Student[] students,home;

    private final ArrayList<String> studentname= new ArrayList<>();

    public Homework() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homework.
     */
    // TODO: Rename and change types and number of parameters
    public static Homework newInstance(String param1, String param2) {
        Homework fragment = new Homework();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homework, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycleviewhome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);


        Gson gson = new Gson();


        students = gson.fromJson(loadJSONFromAsset(requireContext()),Student[].class);

        for (Student student : students) {

        String name = student.getName();

        scores[] list =  student.getScores();
        double score = list[2].getScore();

        if (score >= 35.0d) {
            studentname.add(name);
        }

    }
        home = new Student[studentname.size()];
        int j=0;
        for (Student student : students) {
            scores[] list = student.getScores();
            double score = list[2].getScore();

            if (35.0d <= score) {
                home[j] = new Student(student.getId(), student.getName(), student.getScores());
                j++;
            }

        }
    int n = studentname.size();
        Toast.makeText(getContext(), n+"length", Toast.LENGTH_LONG).show();
    MyAdapter myAdapter = new MyAdapter(getContext(),new ArrayList<String>(studentname),  this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


}

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("students.json");

            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(getActivity(),detail_of_student.class);


        i.putExtra("id",home[position].getId());
        i.putExtra("name",home[position].getName());

        scores[] scores = home[position].getScores();
        Double examscore = scores[0].getScore();
        Double quizscore = scores[1].getScore();
        Double homescore = scores[2].getScore();
        i.putExtra("exam_score",examscore);
        i.putExtra("quiz_score",quizscore);
        i.putExtra("home_score",homescore);

        startActivity(i);
    }

}