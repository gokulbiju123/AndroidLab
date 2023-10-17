package com.example.sjcet.studentregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StudentRegistration extends AppCompatActivity {
    private EditText etName, etEmail, etPhone;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private CheckBox cbMath, cbScience, cbHistory;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
            etName = findViewById(R.id.etName);
            etEmail = findViewById(R.id.etEmail);
            etPhone = findViewById(R.id.etPhone);
            rgGender = findViewById(R.id.rgGender);
            rbMale = findViewById(R.id.rbMale);
            rbFemale = findViewById(R.id.rbFemale);
            cbMath = findViewById(R.id.cbMath);
            cbScience = findViewById(R.id.cbScience);
            cbHistory = findViewById(R.id.cbHistory);
            btnSubmit = findViewById(R.id.btnSubmit);

            btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform validation
                if (validateForm()) {
                    // Form is valid, process the data
                    String name = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    String phone = etPhone.getText().toString();
                    String gender = rbMale.isChecked() ? "Male" : "Female";
                    StringBuilder courses = new StringBuilder();
                    if (cbMath.isChecked()) courses.append("Math, ");
                    if (cbScience.isChecked()) courses.append("Science, ");
                    if (cbHistory.isChecked()) courses.append("History");

                    // Display a toast with the collected data
                    String message = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone
                            + "\nGender: " + gender + "\nCourses: " + courses.toString();
                    Toast.makeText(StudentRegistration.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validateForm() {
        // Basic validation for name, email, and phone
        boolean isValid = true;

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();

        if (name.isEmpty()) {
            etName.setError("Name is required");
            isValid = false;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email address is required");
            isValid = false;
        }

        if (phone.isEmpty() || phone.length() != 10) {
            etPhone.setError("Valid 10-digit phone number is required");
            isValid = false;
        }

        return isValid;
    }
}
