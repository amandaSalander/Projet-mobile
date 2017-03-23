package com.wasp.amanda.projet_mobile;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="EmailPassword" ;
    private  EditText nameField;
    private  EditText emailField;
    private  EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        findViewById(R.id.create_user).setOnClickListener(this);
        nameField = (EditText) findViewById(R.id.field_name);
        emailField = (EditText) findViewById(R.id.field_email_account);
        passwordField = (EditText) findViewById(R.id.field_password_account);

    }

    public void createUser(){
        nameField = (EditText) findViewById(R.id.field_name);
        emailField = (EditText) findViewById(R.id.field_email_account);
        passwordField = (EditText) findViewById(R.id.field_password_account);
        MainActivity.mAuth.createUserWithEmailAndPassword(emailField.getText().toString(), passwordField.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(CreateAccount.this, "Failed to create a user"+emailField.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
//        if (!this.emailField.getText().toString())
        Toast.makeText(this, "I'm trying to create a user ", Toast.LENGTH_SHORT).show();
        this.createUser();
    }
}
