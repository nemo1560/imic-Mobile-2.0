package com.example.hhh.imicmo2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hhh.imicmo2.Entities.VideoGroupEntity;
import com.example.hhh.imicmo2.R;

import java.util.ArrayList;
import java.util.List;

public class VideoGroupAdapter extends RecyclerView.Adapter<VideoGroupAdapter.ViewHolder> {
    private Context context;
    private List<VideoGroupEntity> listVGroup;

    public VideoGroupAdapter(Context context, List<VideoGroupEntity> listVGroup) {
        this.context = context;
        this.listVGroup = listVGroup;
    }

    @NonNull
    @Override
    public VideoGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_fragment_video_group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoGroupAdapter.ViewHolder holder, int position) {
        VideoGroupEntity videoGroupEntity = listVGroup.get(position);
        holder.tvCourse.setText(videoGroupEntity.getVGroupName());
        String imageUrl = videoGroupEntity.getImages();
        Glide.with(context).load(imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listVGroup.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         ImageView imageView;
         TextView tvCourse;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_vgroup);
            tvCourse = itemView.findViewById(R.id.text_vgroup);
        }
    }
}
