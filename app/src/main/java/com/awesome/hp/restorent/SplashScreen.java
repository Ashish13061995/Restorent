package com.awesome.hp.restorent;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//
//        SharedPreferences sp1=this.getSharedPreferences("Login", Integer.parseInt(null));
//
//        final String unm=sp1.getString("Unm", null);
//        String pass = sp1.getString("Psw", null);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {








//                if(sharedPreferences1.getString(this).length() == 0)
//                {
//                    Intent intent = new Intent(SplashScreen.this,User_Login.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    finish();
//                    startActivity(intent);
//                }else
//                {
//                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    finish();
//                    startActivity(intent);
//                }


                Intent intent=new Intent(SplashScreen.this,User_Login.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}
