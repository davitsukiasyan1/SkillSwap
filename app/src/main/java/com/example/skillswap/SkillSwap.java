package com.example.skillswap;

import static com.example.skillswap.R.id.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.skillswap.databinding.ActivitySkillswapBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SkillSwap extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView textView;
    Home home= new Home();
    Chats settings = new Chats();
    Profile profile = new Profile();
    FirebaseAuth auth;
    ImageButton imageButton, imageButton1;
    FirebaseUser user;

    ActivitySkillswapBinding binding;

    @SuppressLint({"NonConstantResourceId", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skillswap);
        getSupportActionBar().hide();


        imageButton =(ImageButton) findViewById(R.id.settings);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SkillSwap.this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SkillSwap.this, Settings.class);
                startActivity(intent);

            }
        });



        imageButton1 = (ImageButton) findViewById(R.id.logout);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SkillSwap.this, "You clicked Log out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });







        auth  = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();

        }

        binding = ActivitySkillswapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Home());
        binding.bottomNavigation.setOnItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();

            if (itemId == R.id.home){
                replaceFragment(new Home());
            }
            else if (itemId == R.id.profile){
                replaceFragment(new Profile());
            }
            else if (itemId == R.id.chats){
                replaceFragment(new Chats());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}