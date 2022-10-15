package com.gergeo.faster_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText username , phone,password ,repassword;
    Button signupbutton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        phone    =(EditText) findViewById(R.id.Phone);
        repassword=(EditText) findViewById(R.id.repassword);
        dbHelper =  new DBHelper(this);

        signupbutton = (Button) findViewById(R.id.signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String NumPhone = phone.getText().toString();

                if (user.equals("")||NumPhone.equals("")||pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(RegistrationPage.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(repass)){
                        Boolean checkuser = dbHelper.CheckUserName(user);
                        if(checkuser ==false){
                            Boolean insert = dbHelper.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(RegistrationPage.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                //after registration , try login
                                Intent intent = new Intent(getApplicationContext(),SignInPage.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegistrationPage.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                                Toast.makeText(RegistrationPage.this,"User already exists. Please sign in or create another account",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistrationPage.this,"Passwords not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}
