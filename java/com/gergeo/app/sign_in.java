package com.gergeo.faster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbutton = (MaterialButton)  findViewById(R.id.loginbutton);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    Toast.makeText(SignIn.this,"Login suсceffull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignIn.this,"Login failed :( ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}