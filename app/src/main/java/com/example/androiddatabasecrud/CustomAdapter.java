package com.example.androiddatabasecrud;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList fsm_id, fsm_gedung, fsm_ruang, fsm_kapasitas;

    CustomAdapter(Activity activity, Context context,
                  ArrayList fsm_id,
                  ArrayList fsm_gedung,
                  ArrayList fsm_ruang,
                  ArrayList fsm_kapasitas) {
        this.activity = activity;
        this.context = context;
        this.fsm_id = fsm_id;
        this.fsm_gedung = fsm_gedung;
        this.fsm_ruang = fsm_ruang;
        this.fsm_kapasitas = fsm_kapasitas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.fsm_id.setText(String.valueOf(fsm_id.get(position)));
        holder.fsm_gedung.setText(String.valueOf(fsm_gedung.get(position)));
        holder.fsm_ruang.setText(String.valueOf(fsm_ruang.get(position)));
        holder.fsm_kapasitas.setText(String.valueOf(fsm_kapasitas.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(fsm_id.get(position)));
                intent.putExtra("gedung", String.valueOf(fsm_gedung.get(position)));
                intent.putExtra("ruang", String.valueOf(fsm_ruang.get(position)));
                intent.putExtra("kapasitas", String.valueOf(fsm_kapasitas.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fsm_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fsm_id, fsm_gedung, fsm_ruang, fsm_kapasitas;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fsm_id = itemView.findViewById(R.id.fsm_id);
            fsm_gedung = itemView.findViewById(R.id.fsm_gedung);
            fsm_ruang = itemView.findViewById(R.id.fsm_ruang);
            fsm_kapasitas = itemView.findViewById(R.id.fsm_kapasitas);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
