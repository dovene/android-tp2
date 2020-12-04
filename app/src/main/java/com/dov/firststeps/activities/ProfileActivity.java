package com.dov.firststeps.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.dov.firststeps.R;
import com.dov.firststeps.model.User;

public class ProfileActivity extends AppCompatActivity {

    public static String USER_KEY = "USER_KEY";
    private AppCompatTextView loginTV;
    private AppCompatImageView profileIV;
    private AppCompatButton logoutBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItems();
    }

    private void setViewItems() {
        loginTV = findViewById(R.id.login_TV);
        logoutBT = findViewById(R.id.logout_BT);
        profileIV = findViewById(R.id.profile_IV);
        User user = (User) getIntent().getSerializableExtra(USER_KEY);
        loginTV.setText(user.getLogin());
        logoutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
        });

        Glide.with(this).load("https://i.pravatar.cc/150?u=a042581f4e29026703d" ).into(profileIV);
    }
}