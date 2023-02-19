package com.example.muftaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {

    EditText  etemail, etpassword;
    Button btnsigin,skip;
    TextView btnforgotpassword,tvsignup;
    ImageView btntweeter, btnfacebook, btngoogle;


    FirebaseAuth mAuth;

    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        getSupportActionBar().hide();

        etemail=findViewById(R.id.ETemail);
        etpassword=findViewById(R.id.ETpassword);
        btnsigin=findViewById(R.id.signinbutton);
        btnforgotpassword=findViewById(R.id.forgotpassword);
        tvsignup=findViewById(R.id.signup);
        btntweeter = findViewById(R.id.tweeter);
        btnfacebook = findViewById(R.id.facebook);
        btngoogle = findViewById(R.id.google);
        skip=findViewById(R.id.skip);

        mAuth = FirebaseAuth.getInstance();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this, MainActivity.class));

            }
        });



        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this, signupactivity.class));
            }

        });


        btnforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecoverPasswordDialog();
            }
        });
        }




    private void loginUser(){
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etemail.setError("Email cannot be empty");
            etemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etpassword.setError("Password cannot be empty");
            etpassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(loginactivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginactivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(loginactivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }





    private void showRecoverPasswordDialog() {


        //AlertDialog.Builder builder=new AlertDialog.Builder(this);
       // builder.setTitle("Recover Password");
      //  LinearLayout linearLayout=new LinearLayout(rec);
       // final EditText emailet= new EditText(this);
        // write the email using which you registered
       // emailet.setText("Email");
       // emailet.setMinEms(16);



       // emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

//
//        linearLayout.addView(emailet);
//        linearLayout.setPadding(10,10,10,10);
//        builder.setView(linearLayout);




        final Dialog dialog = new Dialog(loginactivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.recoverypassworddialoglayout);
        EditText recoveremail = dialog.findViewById(R.id.recoveremail);

        Button btnC;
        Button btnR;
        btnC = dialog.findViewById(R.id.cancelbutton);
        btnR = dialog.findViewById(R.id.recoverbutton);




        // Click on Recover and a email will be sent to your registered email id
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= recoveremail.getText().toString().trim();
               beginRecovery(email);
            }
        });


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();



//        btnR.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String email=emailet.getText().toString().trim();
//                beginRecovery(email);
//            }
//        });

//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
      //  builder.create().show();
    }

    private void beginRecovery(String email) {
        loadingBar = new ProgressDialog(this);
        loadingBar.setMessage("Sending Email....");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        // calling sendPasswordResetEmail
        // open your email and write the new
        // password and then you can login
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                loadingBar.dismiss();
                if(task.isSuccessful())
                {
                    // if isSuccessful then done message will be shown
                    // and you can change the password
                    Toast.makeText(loginactivity.this,"Done sent",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(loginactivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingBar.dismiss();
                Toast.makeText(loginactivity.this,"Error Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
