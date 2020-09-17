package com.example.xaviernara.newmindapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView signUpText,emailText,passwordText,forgotPasswordText, loginButton;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getActionBar().hide();
        //this.getActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signUpText = findViewById(R.id.alreadyRegisteredText);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        loginButton = findViewById(R.id.logintextView);
        progressBar = findViewById(R.id.progressBar2);
        forgotPasswordText = findViewById(R.id.forgotPassword);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void signUpTextOnClick(View view){
        startActivity(new Intent(getApplicationContext(),SignUp.class));
        finish();
    }

    public void loginButtonOnClick(View view){

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

        //authenticate the user in firebase
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Logged In Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else{
                    Toast.makeText(Login.this, "Error :"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });



    }

    //onClick for reseting password text view
    public void forgotPasswordTextOnClick(View view){
        final EditText resetMail = new EditText(view.getContext());
        AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
        passwordResetDialog.setTitle("Reset Password");
        passwordResetDialog.setMessage("Enter Your Email To Receive Link");
        passwordResetDialog.setView(resetMail);

        passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //extract the email and send reset link

                String mail = resetMail.getText().toString();
                mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this,"Reset Link Sent To Your Email", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this,"Error! Reset Link Not Sent To Your Email" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //CLOSE the dialog
            }
        });

        //displays error dialog
        passwordResetDialog.create().show();

    }




}