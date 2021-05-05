package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name,number,mail;
    private Button register;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_EMAIL = "mail";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editname);
        number = findViewById(R.id.editnumber);
        mail = findViewById(R.id.editmail);
        register = findViewById(R.id.reg);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String sname = sharedPreferences.getString(KEY_NAME,null);

        if(sname != null){
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, name.getText().toString());
                editor.putString(KEY_NUMBER, number.getText().toString());
                editor.putString(KEY_EMAIL, mail.getText().toString());
                editor.apply();
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);

                Toast.makeText(MainActivity.this,"Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }
}