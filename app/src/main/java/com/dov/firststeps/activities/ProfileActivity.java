package com.dov.firststeps.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.dov.firststeps.R;

public class ProfileActivity extends AppCompatActivity {

    public static String LOGIN_KEY = "LOGIN_KEY";
    private AppCompatTextView loginTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItems();
    }

    private void setViewItems() {
        loginTV = findViewById(R.id.login_TV);
        loginTV.setText(getIntent().getStringExtra(LOGIN_KEY));
    }
}