package com.example.cerberus.todolistproject;

import android.os.Bundle;
import android.widget.ListView;

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

}
