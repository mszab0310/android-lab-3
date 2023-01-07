package com.example.laborator3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.laborator3.fragments.Fragment1;
import com.example.laborator3.fragments.Fragment2;
import com.example.laborator3.fragments.Fragment3;
import com.example.laborator3.fragments.Fragment4;
import com.example.laborator3.fragments.Fragment5;
import com.example.laborator3.R;

public class MainActivity extends AppCompatActivity {

    Button prevButton, nextButton;
    public FrameLayout frameLayout;

    public Fragment1 fragment1;
    public Fragment2 fragment2;
    public Fragment3 fragment3;
    public Fragment4 fragment4;
    public Fragment5 fragment5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prevButton = findViewById(R.id.pre);
        prevButton.setEnabled(false);
        nextButton = findViewById(R.id.next);
        frameLayout = findViewById(R.id.frameLayout);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        replaceFragment(fragment1);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragment() instanceof Fragment1) {
                    replaceFragment(fragment2);
                    prevButton.setEnabled(true);
                } else if (currentFragment() instanceof Fragment2) {
                    replaceFragment(fragment3);
                } else if (currentFragment() instanceof Fragment3) {
                    replaceFragment(fragment4);
                } else if (currentFragment() instanceof Fragment4) {
                    replaceFragment(fragment5);
                }else if (currentFragment() instanceof Fragment5){
                    replaceFragment(fragment1);
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragment() instanceof Fragment1) {
                    replaceFragment(fragment5);
                } else if (currentFragment() instanceof Fragment2) {
                    replaceFragment(fragment1);
                } else if (currentFragment() instanceof Fragment3) {
                    replaceFragment(fragment2);
                } else if (currentFragment() instanceof Fragment4) {
                    replaceFragment(fragment3);
                } else if (currentFragment() instanceof Fragment5) {
                    replaceFragment(fragment4);
                    nextButton.setEnabled(true);
                }
            }
        });
    }

    public void onClickDetail(View view) {
        Intent detailsIntent;
        detailsIntent = new Intent(this, DetailsActivity.class);
        Toast.makeText(getApplicationContext(), "Loading details...", Toast.LENGTH_LONG).show();
        detailsIntent.putExtra("fragment",String.valueOf(currentFragment()).trim().substring(0,9));

        startActivity(detailsIntent);

    }

    public Fragment currentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.frameLayout);
    }

    private void replaceFragment(Fragment frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, frag);
        fragmentTransaction.commit();

    }
}