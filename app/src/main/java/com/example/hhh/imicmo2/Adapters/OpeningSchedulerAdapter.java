package com.example.hhh.imicmo2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhh.imicmo2.Entities.OpeningScheduler;
import com.example.hhh.imicmo2.R;
import com.example.hhh.imicmo2.Views.Activities.DetailOpenschedulerActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OpeningSchedulerAdapter extends RecyclerView.Adapter<OpeningSchedulerAdapter.MyViewHolder> {
    private Context context;
    private List<OpeningScheduler> openingSchedulerList;
    private Intent intent;

    public OpeningSchedulerAdapter(Context context, List<OpeningScheduler> openingSchedulerList) {
        this.context = context;
        this.openingSchedulerList = openingSchedulerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_fragment_opening_scheduler,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Picasso.get().load(openingSchedulerList.get(i).getImageLink()).into(myViewHolder.imgHinhkhaigiang);
        myViewHolder.txtNgaykhaigiang.setText(openingSchedulerList.get(i).getOpenningDate());
        myViewHolder.txtLocation.setText(openingSchedulerList.get(i).getLocation());
        myViewHolder.imgHinhkhaigiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context.getApplicationContext(),DetailOpenschedulerActivity.class);
                intent.putExtra("OpeningScheduler",openingSchedulerList.get(myViewHolder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return openingSchedulerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgHinhkhaigiang;
        private TextView txtLocation;
        private TextView txtNgaykhaigiang;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhkhaigiang = itemView.findViewById(R.id.imgHinhkhaigiang);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtNgaykhaigiang = itemView.findViewById(R.id.txtNgaykhaigiang);
        }
    }
}
