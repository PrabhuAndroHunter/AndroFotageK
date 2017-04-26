package com.pub.assignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsernameEt, mPasswordEt, mConPasswordEt;
    private Button mSignupBtn;
    private String _username, _password, _conPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUsernameEt = (EditText) findViewById(R.id.editText_signup_username);
        mPasswordEt = (EditText) findViewById(R.id.editText_signup_password);
        mConPasswordEt = (EditText) findViewById(R.id.editText__signup_confirmpassword);
        mSignupBtn = (Button) findViewById(R.id.button_signup_signup);
        mSignupBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getData();
    }

    private void getData() {
        _username = mUsernameEt.getText().toString();
        _password = mPasswordEt.getText().toString();
        _conPassword = mConPasswordEt.getText().toString();
        signUp();
    }


    private void signUp() {
        if (_username.isEmpty() && _password.isEmpty() && _conPassword.isEmpty()) {
            Toast.makeText(this, "Please enter all the data", Toast.LENGTH_SHORT).show();
        } else {
            final Intent myIntent = new Intent(this, MainActivity.class);
            final ProgressDialog progressDialog = new ProgressDialog(this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Creating Account...");
            progressDialog.show();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            startActivity(myIntent);
                            progressDialog.dismiss();
                            Toast.makeText(getBaseContext(), "Account Created Successfully", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }, 3000);       // just for user feel
        }
    }
}
