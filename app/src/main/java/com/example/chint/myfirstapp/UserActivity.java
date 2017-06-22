package com.example.chint.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.chint.myfirstapp.R.styleable.View;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toast.makeText(this, "Successfully Logined", Toast.LENGTH_LONG).show();
        Button a = (Button)findViewById(R.id.a);
        Button b = (Button)findViewById(R.id.b);
        Button c = (Button)findViewById(R.id.c);
        Button d = (Button)findViewById(R.id.d);
    }

    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.a){
            Toast.makeText(this,"Button1 Clicked",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.b){
            Toast.makeText(this,"Button2 Clicked",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.c){
            Toast.makeText(this,"Button3 Clicked",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Button4 Clicked",Toast.LENGTH_LONG).show();
        }
    }

    public void onClickText(View v){
        TextView homepage = (TextView)findViewById(R.id.home);
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}
