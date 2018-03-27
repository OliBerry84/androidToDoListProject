package com.example.cerberus.todolistproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cerberus on 27/03/2018.
 */

public class JobListAdapter extends ArrayAdapter<Job> {

    public JobListAdapter(Context context, ArrayList<Job> list){
        super(context,0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){
        Job currentJob = getItem(position);

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        TextView jobTitle2 = listItemView.findViewById(R.id.jobTitle2);
        jobTitle2.setText((currentJob.getTitle().toString()));

        listItemView.setTag(currentJob);

        return listItemView;
    }
}


