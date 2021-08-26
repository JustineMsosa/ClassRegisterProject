package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button aboutApp;
    Button SignUp;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutApp = (Button) findViewById(R.id.btnAboutApp);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent =  new Intent(MainActivity.this, AboutApp.class);
                startActivity(aboutIntent);

            }
        });

        SignUp = (Button) findViewById(R.id.btnSignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent =  new Intent(MainActivity.this, Register.class);
                startActivity(aboutIntent);

            }
        });

        Login = (Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent =  new Intent(MainActivity.this, Login2.class);
                startActivity(aboutIntent);

            }
        });
    }
}