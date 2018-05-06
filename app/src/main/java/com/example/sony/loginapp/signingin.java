package com.example.sony.loginapp;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class signingin extends AppCompatActivity {
    EditText t1, t2;

    DatabaseHelper db;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DatabaseHelper(this);
        setContentView(R.layout.signingin);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.password2);
        btn1=findViewById(R.id.loginn);






        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usrname=t1.getText().toString();
                String pasword=t2.getText().toString();
                boolean chk= db.UserPassCheck(usrname,pasword);
                if (chk)
                {
                    Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_SHORT).show();
                    Intent inn= new Intent(signingin.this,logoutt.class);
                    startActivity(inn);

                }
                else Toast.makeText(getApplicationContext(),"Incorrect username or password",Toast.LENGTH_SHORT).show();
            }});
    }
}