package com.example.edoctor_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        //Info = (TextView)findViewById(R.id.tvInfo);
        login = (Button)findViewById(R.id.btnLogin); // variable attaching with the IDs

        ImageView mylogo = (ImageView)findViewById(R.id.imgLogo);
        //Info.setText("No of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());//getting the entered name and password
            }
        });

    }


    // function for checking the name and password. Also this will work only when the Login button is pressed.
    private void validate(String userName, String userPassword){
        if((userName.equals("test")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, Main5Activity.class); //from curreent activity to next activity
            startActivity(intent); //strt new activity

        }else{
            counter--;
            // Display the incorrected attempts
            //Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                login.setEnabled(false);
                openDialog();
            }

        }
    }

    public void openDialog(){
        WarningLogin warninglogin = new WarningLogin();
        warninglogin.show(getSupportFragmentManager(), "warning dialog");
    }
}
