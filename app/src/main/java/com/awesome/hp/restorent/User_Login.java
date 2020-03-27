package com.awesome.hp.restorent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_Login extends Activity {

    TextView signup;
    Button btn_login;
    EditText numberId,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        numberId =(EditText) findViewById(R.id.numberId);
        password =(EditText) findViewById(R.id.password);

        signup =(TextView) findViewById(R.id.signup);
        btn_login =(Button) findViewById(R.id.btn_login);

        //saving data in shared priference
//        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putBoolean("isLogin",true);
//        editor.putString("user", String.valueOf(numberId));
//        editor.putString("pass", String.valueOf(password));
//        editor.commit();


        SharedPreferences sp=getSharedPreferences("Login", 0);
        SharedPreferences.Editor Ed=sp.edit();
        Ed.putString("Unm",String.valueOf(numberId));
        Ed.putString("Psw",String.valueOf(password));
        Ed.commit();

        signup =(TextView) findViewById(R.id.signup);
        btn_login =(Button) findViewById(R.id.btn_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_Login.this,UserRegistration.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_Login.this,Home_page.class);
                startActivity(intent);
            }
        });
    }
}
