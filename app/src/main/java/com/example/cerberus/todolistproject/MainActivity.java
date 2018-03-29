package com.example.cerberus.todolistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        DbHelper db = new DbHelper(this);
        ArrayList<Job> list = db.allJobs();

        JobListAdapter jobAdapter = new JobListAdapter(this, list);

        ListView listView = findViewById(R.id.jobList);
        listView.setAdapter(jobAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        DbHelper db = new DbHelper(this);
        ArrayList<Job> list = db.allJobs();

        JobListAdapter jobAdapter = new JobListAdapter(this, list);

        ListView listView = findViewById(R.id.jobList);
        listView.setAdapter(jobAdapter);
    }

    public void onListItemClick(View textViewThatWasSelected) {
        Intent intent = new Intent(this, DetailedDescription.class);
        Job job = (Job) textViewThatWasSelected.getTag();

        intent.putExtra("job", job);
        startActivity(intent);
    }

}