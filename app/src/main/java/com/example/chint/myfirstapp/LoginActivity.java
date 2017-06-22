package com.example.chint.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    DBhealper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new DBhealper(this);
        TextView a = (TextView)findViewById(R.id.noAccount);

        a.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), MainActivity.class);
                startActivity(j);
            }
        });
    }
    public void onClick(View v){
        EditText un = (EditText)findViewById(R.id.uname1);
        EditText up = (EditText)findViewById(R.id.psw1);

        /*SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String username = sp.getString("uname","");
        String password = sp.getString("psw","");*/
        String z = un.getText().toString();
        String psw = helper.onLoginClicked(z);
        if(psw.equals(up.getText().toString())){
            Intent i = new Intent(v.getContext(), UserActivity.class);
            startActivity(i);
        }
        else
            Toast.makeText(this, "Login Failed, Please Try Again", Toast.LENGTH_LONG).show();
    }
}
