package com.example.cerberus.todolistproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import static com.example.cerberus.todolistproject.DbHelper.DATABASE_NAME;

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
    public void onResume(){
        super.onResume();

        DbHelper db = new DbHelper(this);
        ArrayList<Job> list = db.allJobs();

        JobListAdapter jobAdapter = new JobListAdapter(this, list);

        ListView listView = findViewById(R.id.jobList);
        listView.setAdapter(jobAdapter);
    }

}
