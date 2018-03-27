package com.example.cerberus.todolistproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JobActivity extends BaseActivity {

    DbHelper myDatabase;
    EditText jobTitle;
    EditText jobDescription;
    Button addJobBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        Log.d("JobActivity", "onCreate");
        myDatabase = new DbHelper(this);
        jobTitle = findViewById(R.id.jobTitle);
        jobDescription = findViewById(R.id.jobDescription);
        addJobBtn = findViewById(R.id.addJobBtn);
    }

    public void onAddJobButtonClick(View clickedView) {
        Log.d("Main Activity", "AddJob button clicked");
        boolean jobIsAdded = myDatabase.addJob(
                jobTitle.getText().toString(),
                jobDescription.getText().toString());
        if (jobIsAdded == true)
            Toast.makeText(JobActivity.this,"Job Added to List", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(JobActivity.this,"Job NOT Added", Toast.LENGTH_SHORT).show();
    }
}