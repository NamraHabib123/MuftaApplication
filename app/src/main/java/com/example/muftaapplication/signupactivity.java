package com.example.muftaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupactivity extends AppCompatActivity {

    EditText etname, etemail, etpassword, etconfirmpassword;
    Button btnsigup,skip;
    TextView btnforgotpassword,tvsignin;
    ImageView btntweeter, btnfacebook, btngoogle;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        getSupportActionBar().hide();

        etname = findViewById(R.id.ETname);
        etemail = findViewById(R.id.ETemail);
        etpassword = findViewById(R.id.ETpassword);
        etconfirmpassword = findViewById(R.id.ETconfirmpassword);
        btnsigup = findViewById(R.id.signupbutton);
        btnforgotpassword = findViewById(R.id.forgotpassword);
        tvsignin=findViewById(R.id.signin);
        btntweeter = findViewById(R.id.tweeter);
        btnfacebook = findViewById(R.id.facebook);
        btngoogle = findViewById(R.id.google);
        skip=findViewById(R.id.skip);



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupactivity.this, MainActivity.class));

            }
        });


        mAuth = FirebaseAuth.getInstance();


        btnsigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        tvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupactivity.this, loginactivity.class));
            }
        });




    }

    private void createUser() {
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();
        String confirmpassword = etconfirmpassword.getText().toString();


        if (TextUtils.isEmpty(name)) {
            etname.setError("Name cannot be empty");
            etname.requestFocus();
        }
        else if (TextUtils.isEmpty(email)) {
            etemail.setError("Email cannot be empty");
            etemail.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            etpassword.setError("Password cannot be empty");
            etpassword.requestFocus();
        }
        else if (TextUtils.isEmpty(confirmpassword) ) {
            etconfirmpassword.setError("Confirm Password cannot be empty");
            etconfirmpassword.requestFocus();
        }

        else if (!password.equals(confirmpassword))  {
            etconfirmpassword.setError("Confirmpassword is incorrect");
            etconfirmpassword.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(signupactivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signupactivity.this, loginactivity.class));
                    } else {
                        Toast.makeText(signupactivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}