package com.example.sjcet.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText unameEditText;
    private  EditText passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unameEditText = findViewById(R.id.uname1);
        passEditText = findViewById(R.id.pass1);
    }

    public void Login(View view) {
        String username = unameEditText.getText().toString();
        String password = passEditText.getText().toString();
        if (isValidCredentials(username,password)){
            Toast.makeText(this,"login Successful",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"inalid credentials",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isValidCredentials(String username,String password){
        return username.equals("gokul") && password.equals("1234");
    }
}