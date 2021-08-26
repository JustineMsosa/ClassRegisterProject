package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    Button Register;
    TextView Text;
    TextView Login;
    TextView Qoestion;
    TextInputLayout Name;
    TextInputLayout Password;
    TextInputEditText pass, confi;
    TextInputLayout ConfirPassword;
    TextInputLayout Phone;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBaseHelper(this);
        Register =(Button)findViewById(R.id.regButton);
        Login =(TextView) findViewById(R.id.Login);
        Qoestion =(TextView)findViewById(R.id.Question);
        Name =(TextInputLayout) findViewById(R.id.regName);
        Password =(TextInputLayout) findViewById(R.id.regPassword);
        ConfirPassword =(TextInputLayout) findViewById(R.id.regCorfirm);
        Phone =(TextInputLayout) findViewById(R.id.regPhone);
        pass = (TextInputEditText) findViewById(R.id.pass1);
        confi = (TextInputEditText) findViewById(R.id.confirm);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Register.this, Login2.class);
                startActivity(intent);

            }
        });

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

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = Name.getEditText().getText().toString().trim();
                String pwd = Password.getEditText().getText().toString().trim();
                String cnf_pwd = ConfirPassword.getEditText().getText().toString().trim();
                String phone = Phone.getEditText().getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        if(TextUtils.isEmpty(pwd)){
                            Password.setError("Password is required");
                            return;
                        }
                        else if(pwd.length()<6){
                            Password.setError("Password must have minimum of 6 character");
                            return;
                        }
                        else if(TextUtils.isEmpty(user)){
                            Name.setError("Name is required");
                            return;
                        }
                        else if(TextUtils.isEmpty(phone)){
                            Phone.setError("Email/ phone required");
                            return;
                        }

                        else {
                            Toast.makeText(Register.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login2.class);
                            startActivity(intent);
                        }

                    }
                    else{
                        Toast.makeText(Register.this, "Registration error", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(Register.this, "password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}


