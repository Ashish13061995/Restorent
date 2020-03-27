package com.awesome.hp.restorent;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.awesome.hp.restorent.Fragments.Home_Fragment;
import com.awesome.hp.restorent.Fragments.ListFragment;
import com.awesome.hp.restorent.Fragments.Profile_Fragment;

public class Home_page extends AppCompatActivity {

    private TextView mTextMessage;

    private ActionBar toolbar;
    AlertDialog alertDialog;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_my_order);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_profile);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        getSupportActionBar().hide();

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = getSupportActionBar();


        // load the store fragment by default
        toolbar.setTitle("RestaUnity");
        toolbar.setSubtitle("Welcome");
        loadFragment(new Home_Fragment());


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             Fragment fragment;
             switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("RestaUnity");
                    toolbar.setSubtitle("Welcome");
                    fragment = new Home_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_list:
                    toolbar.setTitle("My Orders");
                    toolbar.setSubtitle("");
                    fragment = new ListFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    toolbar.setSubtitle("");
                    fragment = new Profile_Fragment();
                    loadFragment(fragment);
                    return true;

            }

            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        //  transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "back_press", Toast.LENGTH_SHORT).show();
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.costum_dialog);

        Button text_yes = (Button) dialog.findViewById(R.id.btn_yes);
        text_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_no);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}


