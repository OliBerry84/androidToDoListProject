package com.example.cerberus.todolistproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

//    @Override
//    public void onDeleteButtonClick(View view) {
//
//        DbHelper myDatabase = new DbHelper(this);
//
//        String sql = "DELETE FROM todolist_table WHERE id = ?";
//        myDatabase.deleteJob(, new Integer[]{selectedJob.getId()});
//        onResume();
//    }

    public void onReturnButtonClick(View listItem) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}


