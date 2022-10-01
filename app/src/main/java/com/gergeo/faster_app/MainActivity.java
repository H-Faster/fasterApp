package com.gergeo.faster_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gergeo.faster_app.R;
import com.gergeo.faster_app.RegistrationPage;
import com.gergeo.faster_app.SignInPage;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //from main page to sign in//
        button1 = (Button) findViewById(R.id.signinbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_sign_in_activity();
            } //opening sign in page
        });


        //from main page to sign up page
        button2 =(Button) findViewById(R.id.signupbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_sign_up_activity();
            }
        });

    }
    ///fonction to switch pages (main to sign in)
    public void open_sign_in_activity() {
        Intent intent = new Intent(this, SignInPage.class);
        startActivity(intent);
    }
    /// fonction to switch pages (main to sign up)
    public void open_sign_up_activity() {
        Intent intent = new Intent(this, RegistrationPage.class);
        startActivity(intent);
    }






/*
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbutton = (MaterialButton)  findViewById(R.id.loginbutton);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    Toast.makeText(MainActivity.this,"Login suсceffull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Login failed :( ",Toast.LENGTH_SHORT).show();
                }
            }
        });

 */



}