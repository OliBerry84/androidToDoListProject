package com.example.cerberus.todolistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedDescription extends BaseActivity {

    EditText detailedJobTitle;
    TextView detailedJobDescription;
    Button buttonReturn;
    Job selectedJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_description);

        selectedJob = (Job) getIntent().getSerializableExtra("job");

        detailedJobTitle = findViewById(R.id.editDetailedTitle);
        detailedJobTitle.setText(selectedJob.getTitle());

        detailedJobDescription = findViewById(R.id.textDetailedDescription);
        detailedJobDescription.setText((selectedJob.getDescription()));
    }

    public void onUpdateButtonClick(View view){
        DbHelper myDatabase = new DbHelper(this);
        String job = detailedJobTitle.getText().toString();
        if (!job.equals("")) {
            myDatabase.update(job, selectedJob.getId() , selectedJob.getTitle());
            Toast.makeText(this, "Job updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Job not updated", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onDeleteButtonClick(View view){
        DbHelper myDatabase = new DbHelper(this);
        myDatabase.delete(selectedJob.getId(), selectedJob.getTitle());
        detailedJobTitle.setText("");
        detailedJobDescription.setText("");
        Toast.makeText(this, "Job has been deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onReturnButtonClick(View listItem) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}


