package com.example.cerberus.todolistproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    public void onAddJobClick(MenuItem menu){
        Intent intent = new Intent(this, AddJobActivity.class);
        startActivity(intent);
    }
}