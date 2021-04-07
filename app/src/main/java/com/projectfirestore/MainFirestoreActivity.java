package com.projectfirestore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainFirestoreActivity extends AppCompatActivity {

    ImageView btnLogin, btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {

                Fragment fragment = null;
                if (view == findViewById(R.id.btnLogin)) {
                    fragment = new LoginFirestoreFragment();
                } else {
                    fragment = new RegistrationFirestoreFragment();
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment);
                transaction.commit();
            }
        };


        btnLogin = (ImageView) findViewById(R.id.btnLogin);
        btnLogin.setSelected(true);
        btnLogin.setOnClickListener(listener);

        btnRegistration = (ImageView) findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(listener);
    }
}