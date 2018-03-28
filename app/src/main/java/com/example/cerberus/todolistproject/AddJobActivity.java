package com.example.cerberus.todolistproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddJobActivity extends BaseActivity {

    DbHelper myDatabase;
    EditText jobTitle;
    EditText jobDescription;
    Button addJobBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        Log.d("AddJobActivity", "onCreate");
        myDatabase = new DbHelper(this);
        jobTitle = findViewById(R.id.jobTitle);
        jobDescription = findViewById(R.id.jobDescription);
        addJobBtn = findViewById(R.id.addJobBtn);
    }

    public void onAddJobButtonClick(View clickedView) {
        Log.d("AddJobActivity", "AddJob button clicked");
        boolean jobAdded = myDatabase.addJob(
                jobTitle.getText().toString(),
                jobDescription.getText().toString());

        if (jobAdded == true) {
            Toast.makeText(AddJobActivity.this,"Job Added to List", Toast.LENGTH_SHORT).show();
            jobTitle.setText(null);
            jobDescription.setText(null);
        }
        else
            Toast.makeText(AddJobActivity.this, "Job NOT Added", Toast.LENGTH_SHORT).show();
//        (jobTitle.length() != 0) (jobDescription.length() != 0)
    }

}
