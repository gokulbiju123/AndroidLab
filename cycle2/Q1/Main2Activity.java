package com.example.sjcet.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve data from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        username = preferences.getString("username", "DefaultUsername");
        email = preferences.getString("email", "DefaultEmail");
        password = preferences.getString("password", "DefaultPassword");

        // Display the retrieved data in TextViews or perform any actions you need
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);

        usernameTextView.setText("Username: " + username);
        emailTextView.setText("Email: " + email);
    }
}
