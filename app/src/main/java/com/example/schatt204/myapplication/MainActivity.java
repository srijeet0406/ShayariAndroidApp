package com.example.schatt204.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    volatile static HashMap<String, String> vault = new HashMap<String,String>();
    volatile static boolean loggedIn = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        initializeVault();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "(c)Srijeet Chatterjee @ 2017", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact us at : srijeet0406@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        if(!loggedIn)
        {
            fab3.setEnabled(false);
        }
        else
        {
            fab3.setEnabled(true);
        }

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loggedIn) {
                    goToNextPage(view);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not logged in, pls log in first to continue!",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginPage(view);
            }
        });

        Button signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignupPage(view);
            }
        });
    }

    public void initializeVault()
    {
        if(vault.isEmpty() || !vault.containsKey("srijeet0406@gmail.com"))
        {
            vault.put("srijeet0406@gmail.com", "abc");
        }
    }

    public void goToNextPage(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goToLoginPage(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToSignupPage(View view)
    {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void main(String[] args)
    {
        MainActivity activity = new MainActivity();

    }
}
