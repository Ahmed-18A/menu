package com.example.menu_a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Dialog d;
    int x = 0;
    AlertDialog dialog2;
    TextView text;
    private BottomNavigationView nav1;
    public static FrameLayout login, home, cart;
    private HomeFragment homeFrag;
    private secondeFrag cartfrag;
    private thirdFrag loginfrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=findViewById(R.id.frag_home);
        login=findViewById(R.id.frag_in);
        cart=findViewById(R.id.frag_cart);
        homeFrag=new HomeFragment();
        cartfrag=new secondeFrag();
        loginfrag=new thirdFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_cart,cartfrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_in,loginfrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_home,homeFrag).commit();
        home.setVisibility(View.VISIBLE);
        login.setVisibility(View.INVISIBLE);
        cart.setVisibility(View.INVISIBLE);
        nav1=findViewById(R.id.bottom_navigation);
        nav1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mnu_home) {
                    home.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);
                    cart.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.mnu_in) {
                    home.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.VISIBLE);
                    cart.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.mnu_cart) {
                    home.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.INVISIBLE);
                    cart.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }
}