package com.dov.firststeps.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.dov.firststeps.R;
import com.dov.firststeps.model.User;
import com.dov.firststeps.repository.UserRepository;

public class RegistrationActivity extends AppCompatActivity {


    private AppCompatEditText loginET;
    private AppCompatEditText passET;
    private AppCompatEditText nameET;
    private AppCompatButton registerBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItems();
    }

    private void setViewItems() {
        loginET = findViewById(R.id.login_ET);
        passET = findViewById(R.id.pass_ET);
        nameET = findViewById(R.id.name_ET);
        registerBT = findViewById(R.id.register_BT);

        registerBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(loginET.getText().toString(), passET.getText().toString(), nameET.getText().toString());
                UserRepository.getINSTANCE().getUsers().add(user);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}