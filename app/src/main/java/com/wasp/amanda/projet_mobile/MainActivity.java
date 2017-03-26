package com.wasp.amanda.projet_mobile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private static final String TAG = "EmailPassword";

    private EditText mStatusTextView;
    private EditText mDetailTextView;
    private EditText mEmailField;
    private EditText mPasswordField;

    //  firebaseAuth init
    static public FirebaseAuth mAuth;
    // firebaseauth listener init
    static public FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init firebaseauth instance
        mAuth = FirebaseAuth.getInstance();

        /* Views*/

        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);

        /*buttons*/
        findViewById(R.id.sign_in_with_google).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.sign_in_with_email_password).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.anonymously).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.create_account).setOnClickListener((View.OnClickListener) this);


        // listening X)
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };




    }

    public void signIn() {

        Intent intent = new Intent(MainActivity.this, AnnoncementConnected.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "connected hourraaaaa",
                Toast.LENGTH_SHORT).show();


    }

    public void signInWithEmailPassword(String email, String  password){



        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            signIn();
                            Toast.makeText(MainActivity.this, "connecter",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View v) {

        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);

        int i = v.getId();
            if (i==R.id.anonymously){
                Toast.makeText(this, "I'm searching for a house incognito", Toast.LENGTH_SHORT).show();

            }
            else if (i==R.id.create_account){
                Toast.makeText(this, "I'm creating an account", Toast.LENGTH_SHORT).show();
                Intent intentAccount = new Intent(MainActivity.this,CreateAccount.class);
                startActivity(intentAccount);
            }
            else if (i==R.id.sign_in_with_google){
                Toast.makeText(this, "I'm signing in with Google", Toast.LENGTH_SHORT).show();
            }
            else if (i==R.id.sign_in_with_email_password){
                Toast.makeText(this, "I'm signing in with the hard way XD", Toast.LENGTH_SHORT).show();

                this.signInWithEmailPassword(mEmailField.getText().toString(), mPasswordField.getText().toString());
            }
    }
}
