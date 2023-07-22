package com.example.studentdetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<String> studentname;

    private final SelectListener selectListener;

    public MyAdapter(Context context,ArrayList<String> studentname,SelectListener selectListener) {

        this.context= context;
        this.studentname=studentname;
        this.selectListener=selectListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.dataview,parent,false);
        return new MyViewHolder(v,selectListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String name = studentname.get(position);
        holder.studentnameview.setText(name);
    }

    @Override
    public int getItemCount() {
        return studentname.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView studentnameview;

        public MyViewHolder(@NonNull View itemView,SelectListener selectListener) {
            super(itemView);

            studentnameview = itemView.findViewById(R.id.nameofstudent);

            itemView.setOnClickListener(v -> {
                if(selectListener != null){
                    int pos = getAbsoluteAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        selectListener.onItemClick(pos);
                    }
                }
            });
        }
    }
}
