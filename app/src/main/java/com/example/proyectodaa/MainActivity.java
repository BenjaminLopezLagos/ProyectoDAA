package com.example.proyectodaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Button glossaryFragment, characterListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glossaryFragment = findViewById(R.id.glossaryBtn);
        characterListFragment = findViewById(R.id.charListBtn);
        glossaryFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlossaryFragment uf = new GlossaryFragment();
                loadFragment(uf);
            }
        });
        characterListFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharListFragment charListfragment = new CharListFragment();
                loadFragment(charListfragment);
            }
        });
    }


    public void loadFragment(Fragment f) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentsFrameLayout, f);
        transaction.addToBackStack(null);
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        transaction.commit();
    }
}