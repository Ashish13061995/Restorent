package com.awesome.hp.restorent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectChoice extends Activity {

    Button user,restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_choice);

        user=(Button) findViewById(R.id.btn_user);
        restaurant=(Button) findViewById(R.id.btn_restaurent);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectChoice.this,User_Login.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectChoice.this,Restaurant.class);
                startActivity(intent);
            }
        });
    }
}
