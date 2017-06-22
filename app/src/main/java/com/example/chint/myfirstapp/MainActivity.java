package com.example.chint.myfirstapp;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DBhealper healper;
    EditText unamer;
    EditText pswr;
    EditText phoner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        healper = new DBhealper(this);
        TextView a = (TextView) findViewById(R.id.Account);
        a.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                /*Intent j = new Intent(v.getContext(), LoginActivity.class);
                startActivity(j);*/
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                v = getLayoutInflater().inflate(R.layout.activity_login, null);

                Button b = (Button) v.findViewById(R.id.login);
                final EditText un = (EditText)v.findViewById(R.id.uname1);
                final EditText up = (EditText)v.findViewById(R.id.psw1);
                b.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view2){

                        String z = "Praveen";
                        String x = "12345";
                        if((z.equals(un.getText().toString())) && (x.equals(up.getText().toString()))){
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
                    }
                });
                ab.setView(v);
                AlertDialog ad = ab.create();
                ad.show();
            }
        });

        TextView b = (TextView) findViewById(R.id.Buttons);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent j = new Intent(v.getContext(), UserActivity.class);
                startActivity(j);
            }
        });

        unamer = (EditText)findViewById(R.id.uname);
        pswr = (EditText)findViewById(R.id.psw);
        phoner = (EditText)findViewById(R.id.phone);
    }
    protected void onStart(){
        super.onStart();
        Log.d("MainActivity","onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d("MainActivity","onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.d("MainActivity","onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.d("MainActivity","onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    public void onRegisterClick(View v){
        /*SharedPreferences sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("uname",unamer.getText().toString());
        editor.putString("psw",pswr.getText().toString());
        editor.putString("phone",phoner.getText().toString());
        editor.apply();
        Toast.makeText(this, "Succesfully Registered, goto Login Page and Enter your details", Toast.LENGTH_LONG).show();*/
        String name = unamer.getText().toString();
        String pass = pswr.getText().toString();
        String phone = phoner.getText().toString();
        healper.onRegisterClicked(name, pass, phone);
        Toast.makeText(this, "Succesfully Registered, goto Login Page and Enter your details", Toast.LENGTH_LONG).show();
    }
}

