package com.wasp.amanda.projet_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{

    private static final String TAG = "EmailPassword";
    private static final int RC_SIGN_IN = 9001;
    //  firebaseAuth init
    static public FirebaseAuth mAuth;
    // firebaseauth listener init
    static public FirebaseAuth.AuthStateListener mAuthListener;
    private final int MAX_BUTTONS = 4;
    private EditText mEmailField;
    private EditText mPasswordField;
    private ViewGroup buttonsContainer;
    private Button activeButton=null;
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init firebaseauth instance
        mAuth = FirebaseAuth.getInstance();

        /* Views*/

        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();



        this.buttonsContainer = (ViewGroup) findViewById(R.id.buttonContainer);

        int buttonsSpacing = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        int buttonSize = (int) getResources().getDimension(R.dimen.button_size);

        for (int i = 0; i < MAX_BUTTONS; i++) {
            Button button;
//            button = (Button) getLayoutInflater().inflate(R.layout.rectangle_button_sign_in, buttonsContainer, false);
//            button.setText(R.string.sign_in);

            switch (i){
                case 0:
                    button = (Button) getLayoutInflater().inflate(R.layout.rectangle_button_layout, buttonsContainer, false);
                    button.setText(R.string.create_account);
                    break;
                case 1:
                    button = (Button) getLayoutInflater().inflate(R.layout.rectangle_button_sign_in, buttonsContainer, false);
                    button.setText(R.string.sign_in);
                    break;
                case 2:
                    button = (Button) getLayoutInflater().inflate(R.layout.rectangle_google, buttonsContainer, false);
                    button.setText(R.string.sign_in_with_google);
                    break;
                default:
                    button = (Button) getLayoutInflater().inflate(R.layout.rectangle_button_layout, buttonsContainer, false);
                    button.setText(R.string.continue_without_sign_in);
            }

            button.setOnClickListener(this);
            buttonsContainer.addView(button);


        }


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

        Intent intent = new Intent(MainActivity.this, AnnonceListActivity.class);
        intent.putExtra("connecter",true);
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
        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);

        Button b= (Button)v;
        if (b.getText().toString().equals("Create account")){
            Toast.makeText(this, "I'm creating an account", Toast.LENGTH_SHORT).show();
            Intent intentAccount = new Intent(MainActivity.this,CreateAccount.class);
            startActivity(intentAccount);
        }
        else if(b.getText().toString().equals("Sign In")){
            Toast.makeText(this, "I'm signing in with the hard way XD", Toast.LENGTH_SHORT).show();

            this.signInWithEmailPassword(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }
        else if (b.getText().toString().equals("Continue without sign in")){
            mAuth.signInAnonymously();
            activeButton=null;
            selectButton(b);
            Toast.makeText(this, "I'm searching for a house incognito", Toast.LENGTH_SHORT).show();
            Intent intentAccount = new Intent(MainActivity.this,AnnoncesNonConnectees.class);
            intentAccount.putExtra("connecter",false);
            startActivity(intentAccount);

        }
        else if (b.getText().toString().equals("Sign in with Google")){
            signInWithGoogle();
        }


    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }



    private void signInWithGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
                signIn();

            } else {
                // Google Sign In failed, update UI appropriately
                // ...
                Toast.makeText(MainActivity.this,"Failed to connect", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }


}
