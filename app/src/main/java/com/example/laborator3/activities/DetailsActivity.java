package com.example.laborator3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.laborator3.fragments.FragmentText1;
import com.example.laborator3.fragments.FragmentText2;
import com.example.laborator3.fragments.FragmentText3;
import com.example.laborator3.fragments.FragmentText4;
import com.example.laborator3.fragments.FragmentText5;
import com.example.laborator3.R;

public class DetailsActivity extends AppCompatActivity {
    private String fragment;
    private FragmentText1 fragmentText1 = new FragmentText1();
    private FragmentText2 fragmentText2 = new FragmentText2();
    private FragmentText3 fragmentText3 = new FragmentText3();
    private FragmentText4 fragmentText4 = new FragmentText4();
    private FragmentText5 fragmentText5 = new FragmentText5();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        fragment = intent.getStringExtra("fragment");
        System.out.println(fragment);

        switch (fragment) {
            case "Fragment1":
                replaceFragment(fragmentText1);
                break;
            case "Fragment2":
                replaceFragment(fragmentText2);
                break;
            case "Fragment3":
                replaceFragment(fragmentText3);
                break;
            case "Fragment4":
                replaceFragment(fragmentText4);
                break;
            case "Fragment5":
                replaceFragment(fragmentText5);
                break;
        }
    }

    public void onClickBack(View v) {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Returning to main activity", Toast.LENGTH_LONG).show();

        startActivity(mainActivityIntent);
    }

    private void replaceFragment(Fragment frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2, frag);
        fragmentTransaction.commit();

    }
}