package com.example.schatt204.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by schatt204 on 7/19/17.
 */

public class LoginActivity extends Activity {

    static int unsuccessfulAttempts = 0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText pswd = (EditText) findViewById(R.id.pswd);
        pswd.setY(105);
        final Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setY(225);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAuthentication(view))
                {
                    MainActivity.loggedIn=true;
                    goToMainPage(view);
                }
                else
                {
                    if (unsuccessfulAttempts <= 3)
                    {
                        if(checkAuthentication(view))
                        {
                            MainActivity.loggedIn = true;
                            goToMainPage(view);
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "3 unsuccessful attempts! Your account has been locked, sorry!",Toast.LENGTH_LONG).show();
                        loginButton.setEnabled(false);
                    }
                }
            }
        });

    }

    public boolean checkAuthentication(View view)
    {
        EditText email = (EditText) findViewById(R.id.email);
        EditText pswd  = (EditText) findViewById(R.id.pswd);
        String emailVal = email.getText().toString();
        String pswdVal  = pswd.getText().toString();
        System.out.println("Username is " + emailVal + " and pswd is " + pswdVal);
        boolean result = true;
        if(MainActivity.vault.containsKey(emailVal))
        {
            if(MainActivity.vault.get(emailVal).equals(pswdVal))
            {
                Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                result = true;
                unsuccessfulAttempts = 0;
            }
            else
            {
                result = false;
                Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                pswd.setText("");
                unsuccessfulAttempts++;
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "This User doesn't exist. Pls sign up first.",Toast.LENGTH_SHORT).show();
            pswd.setText("");
            goToSignupPage(view);
            result = false;
        }

        return result;
    }

    public void goToNextPage(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void goToSignupPage(View view)
    {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    public void goToMainPage(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
