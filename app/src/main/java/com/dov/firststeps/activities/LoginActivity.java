package com.dov.firststeps.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dov.firststeps.R;
import com.dov.firststeps.model.User;
import com.dov.firststeps.repository.UserRepository;

public class LoginActivity extends AppCompatActivity {

    AppCompatEditText loginET;
    AppCompatEditText passET;
    AppCompatButton loginBT;
    AppCompatTextView registrationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setViewItems();
    }

    private void setViewItems() {
        loginET = findViewById(R.id.login_ET);
        loginBT = findViewById(R.id.loginBT);
        passET = findViewById(R.id.password_ET);
        registrationTV = findViewById(R.id.registration_TV);

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUserAlreadyRegistered(loginET.getText().toString(),passET.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this, UsersActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,"Accès refusé",Toast.LENGTH_LONG).show();
                }
            }
        });

        registrationTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }

    private boolean isUserAlreadyRegistered(String login, String pass){
        boolean result = false;
        for (User user: UserRepository.getINSTANCE().getUsers()){
            if (user.isOkForLogin(login, pass)){
                return true;
            }
        }
        return result;
    }
}