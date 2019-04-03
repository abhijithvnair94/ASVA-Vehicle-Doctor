package com.example.edoctor_beta;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {

    CheckBox tire, lamp, brake, horn, wiper;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        //done switch
        done = (Button) findViewById(R.id.donebtn);
        // initiate views

        tire = (CheckBox) findViewById(R.id.tirePressure);
        tire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tire.isChecked())
                    Toast.makeText(getApplicationContext(), "Tire Checked", Toast.LENGTH_LONG).show();
            }
        });
        lamp = (CheckBox) findViewById(R.id.lampCondition);
        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lamp.isChecked())
                    Toast.makeText(getApplicationContext(), "Lamp Checked", Toast.LENGTH_LONG).show();
            }
        });
        horn = (CheckBox) findViewById(R.id.hornFuel);
        horn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horn.isChecked())
                    Toast.makeText(getApplicationContext(), "Horn and Fuel Checked", Toast.LENGTH_LONG).show();
            }
        });
        brake = (CheckBox) findViewById(R.id.brakeCondition);
        brake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (brake.isChecked())
                        Toast.makeText(getApplicationContext(), "Brake Checked", Toast.LENGTH_LONG).show();
                }
        });

        wiper = (CheckBox) findViewById(R.id.wiperCheck);
        wiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wiper.isChecked())
                    Toast.makeText(getApplicationContext(), "Wiper Checked", Toast.LENGTH_LONG).show();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main9Activity.this, Main5Activity.class); //from curreent activity to next activity
                startActivity(intent);
            }
        });

    }
    /*@Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.androidCheckBox:
                if (android.isChecked())
                    Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_LONG).show();
                break;
            case R.id.javaCheckBox:
                if (java.isChecked())
                    Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_LONG).show();
                break;
            case R.id.phpCheckBox:
                if (php.isChecked())
                    Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_LONG).show();
                break;
            case R.id.pythonCheckBox:
                if (python.isChecked())
                    Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_LONG).show();
                break;
            case R.id.unityCheckBox:
                if (unity3D.isChecked())
                    Toast.makeText(getApplicationContext(), "Unity 3D", Toast.LENGTH_LONG).show();
                break;
        }*/
}
