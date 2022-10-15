package com.gergeo.faster_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {

    EditText username , password;
    Button btnlogin;
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        dbHelper = new DBHelper(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.loginbutton);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                {
                    Toast.makeText(SignInPage.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = dbHelper.CheckUserNamePassword(user,pass);
                    if (checkuserpass == true){
                        Toast.makeText(SignInPage.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(getApplicationContext(), CLASSES POUR LES OPTIONS);
                        //startActivity(intent);
                    }
                    else{
                        Toast.makeText(SignInPage.this, "SInvalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}