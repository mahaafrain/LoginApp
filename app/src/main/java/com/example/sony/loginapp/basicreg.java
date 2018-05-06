package com.example.sony.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class basicreg extends AppCompatActivity {
    EditText e1, e2,e3;
    DatabaseHelper db;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db =new DatabaseHelper(this);
        setContentView(R.layout.activity_basicreg);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
        e3=findViewById(R.id.cpassword);
        b1=findViewById(R.id.registerbtn);
        b2=findViewById(R.id.login2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt= new Intent(basicreg.this,signinginn.class);
                startActivity(intt);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals(""))
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                else {
                    if (s2.equals(s3)) {
                        boolean is_username_unique = db.CheckUsername(s1);
                        if (is_username_unique == true) {
                            boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Successful SignUp", Toast.LENGTH_SHORT).show();
                                Intent go_to_login = new Intent(basicreg.this, signinginn.class);
                                startActivity(go_to_login);

                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Username is already taken!", Toast.LENGTH_SHORT).show();
                            ;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }

            // ;
        });}}
