package com.example.finaliproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaliproject.Database.DataBaseHelper;

public class Login extends AppCompatActivity {
    Button Login;
    TextView Text;
    TextView Register;
    EditText Name;
    EditText Password;
    EditText ConfirmPassword;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseHelper(this);
        Login =(Button)findViewById(R.id.Deletenbtn);
        Text =(TextView)findViewById(R.id.regtextView);
        Name = (EditText)findViewById(R.id.Name);
        Password = (EditText)findViewById(R.id.Password);
        ConfirmPassword = (EditText)findViewById(R.id.ConfirmPassword);
        Register = (TextView) findViewById(R.id.registertextView);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent =  new Intent(Login.this, com.example.finaliproject.Register.class);
                startActivity(registerIntent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = Name.getText().toString().trim();
                String pwd = Password.getText().toString().trim();
                String cfc_pwd = ConfirmPassword.getText().toString().trim();
//                db.deleteUser(user, pwd);
//                Toast.makeText(MainActivity.this, "Database deleted", Toast.LENGTH_SHORT).show();


                Boolean res = db.checkUser(user, pwd);


                if(res == true){
                    if(TextUtils.isEmpty(pwd)){
                        Password.setError("Password is required");
                        return;
                    }
                    else if(pwd.equals(cfc_pwd)) {
                        Toast.makeText(Login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                        Intent registerIntent =  new Intent(Login.this, Welcome.class);
                        startActivity(registerIntent);
                    }
                    else {
                        Toast.makeText(Login.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(Login.this, "Logged Error", Toast.LENGTH_SHORT).show();
                }
            }
        } );



    }


}
