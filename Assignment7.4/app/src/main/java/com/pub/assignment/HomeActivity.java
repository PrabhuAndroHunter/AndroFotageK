package com.pub.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private TextView mUsernameTv;
    private String _username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUsernameTv = (TextView) findViewById(R.id.textView_homeActivity_username);
        Intent intentData = getIntent();
        _username = intentData.getStringExtra("USERNAME");
        mUsernameTv.setText("Welcome to " + _username);
        Toast.makeText(this, "Welcome to " + _username, Toast.LENGTH_SHORT).show();
    }
}
