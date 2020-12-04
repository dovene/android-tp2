package com.dov.firststeps.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.dov.firststeps.R;
import com.dov.firststeps.repository.UserRepository;

public class UsersActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private UsersRecyclerViewAdapter usersRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItems();
    }

    private void setViewItems() {
        recyclerView = findViewById(R.id.user_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersRecyclerViewAdapter = new UsersRecyclerViewAdapter(UserRepository.getINSTANCE().getUsers());
        recyclerView.setAdapter(usersRecyclerViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}