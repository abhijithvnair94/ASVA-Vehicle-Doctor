package com.example.edoctor_beta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.edoctor_beta.ui.phone.Main6Activity;

public class Main5Activity extends AppCompatActivity {

    //private FloatingActionButton mAddReminderButton;
    private Button btncheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab_1);
        btncheck = (Button) findViewById(R.id.notificationbtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class); //from current activity to next activity
                startActivity(intent);
            }
        });

        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent123 = new Intent(Main5Activity.this, Main9Activity.class); //from current activity to next activity
                startActivity(intent123);
            }
        });

    }
}
