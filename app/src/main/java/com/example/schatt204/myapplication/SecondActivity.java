package com.example.schatt204.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by schatt204 on 4/29/17.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup code
                goToLifePage(v);
            }
        });

        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup code
                goToHappyPage(v);
            }
        });

        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup code
                goToHeartBreakPage(v);
            }
        });

        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup code
                goToLonelyPage(v);
            }
        });
    }

    public void goToLifePage(View view)
    {
        Intent intent = new Intent(this, LifeActivity.class);
        startActivity(intent);
    }

    public void goToHappyPage(View view)
    {
        Intent intent = new Intent(this, HappyActivity.class);
        startActivity(intent);
    }

    public void goToHeartBreakPage(View view)
    {
        Intent intent = new Intent(this, HeartBreakActivity.class);
        startActivity(intent);
    }

    public void goToLonelyPage(View view)
    {
        Intent intent = new Intent(this, LonelyActivity.class);
        startActivity(intent);
    }

}
