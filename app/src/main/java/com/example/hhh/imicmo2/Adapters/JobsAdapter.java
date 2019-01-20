package com.example.hhh.imicmo2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.hhh.imicmo2.Entities.Jobs;
import com.example.hhh.imicmo2.Presenters.JobRecuitmentFragment.SendData;
import com.example.hhh.imicmo2.R;

import java.util.List;

public class JobsAdapter extends ArrayAdapter<Jobs> {
    private Context context;
    private int resource;
    private List<Jobs> jobsList;
    private SendData sendData;

    public JobsAdapter(@NonNull Context context, int resource, @NonNull List<Jobs> objects,SendData sendData) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.jobsList = objects;
        this.sendData = sendData;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(resource,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.CorporationId = view.findViewById(R.id.CorporationId);
            viewHolder.Title = view.findViewById(R.id.Title);
            viewHolder.LocationName = view.findViewById(R.id.LocationName);
            viewHolder.Salary = view.findViewById(R.id.Salary);
            viewHolder.Deadline = view.findViewById(R.id.Deadline);
            viewHolder.nopCV_Btn = view.findViewById(R.id.nopCV_Btn);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.CorporationId.setText(jobsList.get(position).getCorporationId());
        viewHolder.Title.setText(jobsList.get(position).getTitle());
        viewHolder.Deadline.setText(jobsList.get(position).getDeadline());
        viewHolder.LocationName.setText(jobsList.get(position).getLocationName());
        viewHolder.Salary.setText(jobsList.get(position).getSalary());
        viewHolder.nopCV_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData.SendPosition(position);
            }
        });
        return view;
    }

    static class ViewHolder{
        TextView CorporationId,
                Title,
                LocationName,
                Salary,
                Deadline;
        Button nopCV_Btn;
    }
}
