package com.pub.assignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailEt, mPasswordEt;
    private Button mLoginBtn;
    private TextView mSignupTv;
    private String _userName, _password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEt = (EditText) findViewById(R.id.editText_mainActivity_email);
        mPasswordEt = (EditText) findViewById(R.id.editText2_mainActivity_password);
        mLoginBtn = (Button) findViewById(R.id.button_mainActivity_login);
        mSignupTv = (TextView) findViewById(R.id.textView_mainActivity_signup);

        mLoginBtn.setOnClickListener(this);
        mSignupTv.setOnClickListener(this);
        registerForContextMenu(mLoginBtn);
    }

    /*  For Option menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_home) {
            Toast.makeText(this, "Home option selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_mainActivity_login:
                collectData();
                break;

            case R.id.textView_mainActivity_signup:
                Intent signUpIntent = new Intent(this, SignupActivity.class);
                startActivity(signUpIntent);
                finish();
                break;
        }
    }

    private void signIn() {
        if (_userName.equals("user@acadgild.com") && _password.equals("password")) {
            final Intent myIntent = new Intent(this, HomeActivity.class);
            final ProgressDialog progressDialog = new ProgressDialog(this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("SignIn...");
            progressDialog.show();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            myIntent.putExtra("USERNAME", _userName);
                            startActivity(myIntent);
                            progressDialog.dismiss();
                            finish();
                        }
                    }, 3000);       // just for user feel


        } else {
            mEmailEt.setText("");
            mPasswordEt.setText("");
            Toast.makeText(this, "E_mail : user@acadgild.com \n password : password", Toast.LENGTH_LONG).show();
        }
    }

    private void collectData() {
        _userName = mEmailEt.getText().toString();
        _password = mPasswordEt.getText().toString();
        validate();
    }

    private void validate() {
        if (_userName.equals("") && _password.equals("")) {
            mEmailEt.setError("Email_Id is Mandatory");
            mPasswordEt.setError("Password is Mandatory");
            mEmailEt.requestFocus();
        } else if (_userName.equals("")) {
            mEmailEt.setError("Please enter your email_Id");
            mEmailEt.requestFocus();
        } else if (_password.equals("")) {
            mPasswordEt.setError("Please enter your password");
            mPasswordEt.requestFocus();
        } else
            signIn();
    }
}
