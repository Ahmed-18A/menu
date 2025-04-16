package com.example.menu_a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Dialog d;
    int x=0;
    AlertDialog dialog2;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();
                if(id==R.id.page1)
                    cart();
                if(id==R.id.out)
                    if (x==1)
                        createLogoutDialog().show();
                    else
                        Toast.makeText(MainActivity.this, "you aren't logged in", Toast.LENGTH_SHORT).show();
                if(id==R.id.in)
                    d.show();
                return true;
            }
        });

        text=findViewById(R.id.text);
        d = new Dialog(this);
        d.setContentView(R.layout.custom_dialog);
        EditText name = d.findViewById(R.id.name);
        EditText pass = d.findViewById(R.id.pass);
        Button log = d.findViewById(R.id.log);
        Button cancel = d.findViewById(R.id.cancel);
        d.setCancelable(true);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pass.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (username.equals("admin") && password.equals("admin")) {
                        text.setText("Hello admin");
                        d.dismiss();
                        x=1;
                    }
                    else {
                        Toast.makeText(MainActivity.this, "wrong info", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });


    }

    private AlertDialog.Builder createLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm logout?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                out();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        return builder;
    }

    public void cart() {
        if(x==1) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(this, "you must be logged in", Toast.LENGTH_SHORT).show();
    }

    public void out(){
        text.setText("Hello user");
        x=0;
    }
}