package com.example.schatt204.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by schatt204 on 7/19/17.
 */

public class SignupActivity extends Activity{

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button   signupButton = (Button)   findViewById(R.id.signupButton2);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSignupValues(view))
                {
                    MainActivity.loggedIn = true;
                    //goToNextPage(view);
                    goToMainPage(view);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid values entered, pls try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void goToMainPage(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextPage(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private boolean checkSignupValues(View view) {

        EditText firstName   = (EditText) findViewById(R.id.firstName);
        EditText lastName    = (EditText) findViewById(R.id.lastName);
        EditText email       = (EditText) findViewById(R.id.signupemail);
        EditText pswd        = (EditText) findViewById(R.id.signupPswd);
        EditText address     = (EditText) findViewById(R.id.address);

        if((firstName.getText() != null) && (!firstName.getText().toString().equals("")) &&
                (lastName.getText() != null) && (!lastName.getText().toString().equals("")) &&
                (email.getText() != null) && (!email.getText().toString().equals("")) &&
                (pswd.getText() != null) && (!pswd.getText().toString().equals("")) &&
                (address.getText() != null) && (!address.getText().toString().equals("")))
        {
            if(MainActivity.vault.containsKey(email.getText().toString()))
            {
                Toast.makeText(getApplicationContext(), "Username already exists, pls try again!",Toast.LENGTH_LONG).show();
                return false;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Signup successful!",Toast.LENGTH_LONG).show();
                MainActivity.vault.put(email.getText().toString(), pswd.getText().toString());
                return true;
            }
        }
        else
        {
            return false;
        }
    }
}
