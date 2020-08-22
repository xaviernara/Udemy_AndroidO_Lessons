package com.example.xaviernara.newmindapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class SignUp extends AppCompatActivity {

    EditText fullName,emailText,passwordText,address;
    TextView alreadyRegisteredText,registerButton;
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
        registerButton = findViewById(R.id.registerTextView);
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



                    /*
                    //send verification link
                    FirebaseUser user = mAuth.getCurrentUser();
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(SignUp.this,"Verification Email Sent",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("TAG","onFailure: Email not sent "+e.getMessage());
                        }
                    });

                   String userId =mAuth.getCurrentUser().getUid();
                   DocumentReference documentReference = fStore.collction("users").document(userId);
                   Map<String,String> userMap =new HashMap<>();
                   userMap.put("fullName",fullName);
                   userMap.put("email",email);
                   userMap.put("address",address);


                     */






                    Toast.makeText(SignUp.this, "User Created",Toast.LENGTH_SHORT).show();
                    sendGreetingsEmail();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else{
                    Toast.makeText(SignUp.this, "Error :"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });



    }

    public void loginTextOnClick(View view){
        startActivity(new Intent(getApplicationContext(), Login.class));
        //finish();
    }

    //Used to send the new user the greetings email after signing up
    protected void sendGreetingsEmail(){
        Log.i("Send Email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailText.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Welcome to New Mind Kingdom Ministries!");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Greetings Message");

        try{
            startActivity(Intent.createChooser(emailIntent,"Send New User Email..."));
            finish();
            Log.i("Finish Sending Email", "");

        }catch(android.content.ActivityNotFoundException ex){

            Toast.makeText(SignUp.this,"Error: "+ex.getMessage(),Toast.LENGTH_SHORT).show();

        }


    }



}