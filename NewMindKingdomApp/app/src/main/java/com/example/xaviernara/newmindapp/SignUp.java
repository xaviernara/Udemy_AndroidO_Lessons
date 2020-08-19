package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;

public class SignUp extends AppCompatActivity {

    EditText fullName,emailText,passwordText,address;
    Button registerButton;
    TextView alreadyRegisteredText;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName= findViewById(R.id.fullName);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        address = findViewById(R.id.addressText);
        registerButton = findViewById(R.id.registerButton);
        alreadyRegisteredText = findViewById(R.id.alreadyRegisteredText);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        //if the user is already logged in & registered they will be directed to the Home activity
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            Toast.makeText(SignUp.this,"Welcome "+mAuth.getCurrentUser(), Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void RegisterButtonOnClick(View view){

        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            emailText.setError("Email is Required");
            return;
        }

        if(TextUtils.isEmpty(password)){
            emailText.setError("Password is Required");
            return;
        }

        if(password.length() < 6){
            emailText.setError("Password has to be Greater than 6 Characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //registering the user in firebase
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this, "User Created",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else{
                    Toast.makeText(SignUp.this, "Error :"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });



    }



}