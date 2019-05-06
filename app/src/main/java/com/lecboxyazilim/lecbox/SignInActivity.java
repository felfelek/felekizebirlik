package com.lecboxyazilim.lecbox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class SignInActivity extends AppCompatActivity {
    Button signInButton;
    EditText sEmailEditText;
    EditText sPassEditText;
    FirebaseAuth signInAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInButton = findViewById(R.id.signInButton);
        sEmailEditText = findViewById(R.id.sEmailEditText);
        sPassEditText = findViewById(R.id.sPassEditText);
        signInAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sEmailEditText.getText().toString().isEmpty()) {

                    sEmailEditText.setError("Lütfen doldurunuz.");
                    sEmailEditText.requestFocus();

                }
                if (sPassEditText.getText().toString().isEmpty()) {
                    sPassEditText.setError("Lütfen doldurunuz.");
                    sPassEditText.requestFocus();
                }

                if (!sEmailEditText.getText().toString().isEmpty() && !sPassEditText.getText().toString().isEmpty()) {
                    signInAuth.signInWithEmailAndPassword(sEmailEditText.getText().toString(), sPassEditText.getText().toString()).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Intent signInSuccesIntent = new Intent(SignInActivity.this, MainActivity.class);
                            startActivity(signInSuccesIntent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if (e instanceof FirebaseAuthInvalidCredentialsException) {

                                Toast.makeText(SignInActivity.this, "Mail adresi veya şifre hatalı.", Toast.LENGTH_LONG).show();

                            }

                        }
                    });


                }
            }
        });
    }

}
