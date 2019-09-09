package com.example.user.firstbuttonapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        // Launches Google Translate, before the first button is shown in our app

        Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");



        // Google Translate is installed on device - launch it

        if (gtIntent != null) {
            startActivity(gtIntent);


            Handler handler = new Handler();

            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    Intent firstActivityIntent = new Intent(getApplicationContext(), FirstActivity.class);
                    startActivity(firstActivityIntent);
                }
            }, 1000);

        }



        // Google Translate is not installed on device - launch Google Play to install GT

        else {
            Intent gtInStore = new Intent(Intent.ACTION_VIEW);
            gtInStore.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.translate"));
            startActivity(gtInStore);
        }
    }
}
