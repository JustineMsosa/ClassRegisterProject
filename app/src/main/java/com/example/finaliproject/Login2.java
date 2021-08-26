package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login2 extends AppCompatActivity {
    Button btn;
    TextInputLayout Name;
    TextInputLayout Password;
    TextInputEditText pass;
    DataBaseHelper db;
    TextView Register,   ForgotPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn = (Button) findViewById(R.id.button2);
        Register =(TextView) findViewById(R.id.Register1);
        db = new DataBaseHelper(this);
        Password = (TextInputLayout) findViewById(R.id.Password);
        Name = (TextInputLayout) findViewById(R.id.Name);
        ForgotPassword = (TextView) findViewById(R.id.ForgPassword);
        pass = (TextInputEditText)findViewById(R.id.pass);

        pass.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                 if(pass.length()<6){
                    pass.setError("minimum of 6 character");
                    return;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Please Contact Admin", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Login2.this, Register.class);
                startActivity(intent);
                
            }
        });

        String user = Name.getEditText().getText().toString().trim();
        String pwd = Password.getEditText().getText().toString().trim();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Name.getEditText().getText().toString().trim();
                String pwd = Password.getEditText().getText().toString().trim();

                Boolean res = db.checkUser(user, pwd);

                if(TextUtils.isEmpty(pwd)){
                    Password.setError("Password is required!");
                    return;
                }
                else if (TextUtils.isEmpty(user)){
                    Name.setError("User Name is required");
                    return;
                }

                else {
                    if (res == true){
                        Toast.makeText(Login2.this, "Logg in succefully", Toast.LENGTH_SHORT).show();
                        Intent intent1 =  new Intent(Login2.this, Welcome.class);
                        startActivity(intent1);


                    }
                    else {
                        Toast.makeText(Login2.this, "Account not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}