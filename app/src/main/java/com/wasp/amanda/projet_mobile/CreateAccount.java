package com.wasp.amanda.projet_mobile;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="EmailPassword" ;
//    private  EditText nameField;
    private  EditText emailField;
    private  EditText passwordField;

    private ViewGroup buttonsContainer;
    private Button activeButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
//        findViewById(R.id.create_user).setOnClickListener(this);
//        nameField = (EditText) findViewById(R.id.field_name);
        emailField = (EditText) findViewById(R.id.field_email_account);
        passwordField = (EditText) findViewById(R.id.field_password_account);


        this.buttonsContainer = (ViewGroup) findViewById(R.id.createContainer);

        int buttonsSpacing = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        int buttonSize = (int) getResources().getDimension(R.dimen.button_size);

        Button button = (Button) getLayoutInflater().inflate(R.layout.rectangle_button_layout, buttonsContainer, false);
        button.setText(R.string.create_user);

        button.setOnClickListener(this);
        buttonsContainer.addView(button);


    }

    public void createUser(){
//        nameField = (EditText) findViewById(R.id.field_name);
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
                        else{
                            Toast.makeText(CreateAccount.this, "Created User "+emailField.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        // ...
                    }
                });
    }

    private void selectButton(Button button) {
        if (activeButton != null) {
            activeButton.setSelected(false);
            activeButton = null;
        }

        activeButton = button;
        button.setSelected(true);
    }

    @Override
    public void onClick(View v) {

        selectButton( (Button)v);
        Button b= (Button) v;



//        if (!this.emailField.getText().toString())
        if (emailField.getText().toString().trim().equalsIgnoreCase("")) {
            emailField.setError("This field can not be blank");
        }
        if (passwordField.getText().toString().trim().equalsIgnoreCase("")) {
            passwordField.setError("This field can not be blank");
        }
        else {
            if(b.getText().toString().equals("Create User")){
                Toast.makeText(this, "I'm trying to create a user ", Toast.LENGTH_SHORT).show();
                this.createUser();
            }
        }
    }
}
