package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView text_name,text_number,text_mail;
    Button back;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_EMAIL = "mail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text_name = findViewById(R.id.name);
        text_number = findViewById(R.id.number);
        text_mail = findViewById(R.id.mail);
        back = findViewById(R.id.back);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String sname = sharedPreferences.getString(KEY_NAME,null);
        String number = sharedPreferences.getString(KEY_NUMBER,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);

        if(sname != null || email !=null || number !=null){
            text_name.setText("Name:"+sname);
            text_number.setText("Mobile Number:"+number);
            text_mail.setText("E-mail id:"+email);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"Log Out Successful",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}