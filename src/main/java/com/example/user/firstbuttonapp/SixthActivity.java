package com.example.user.firstbuttonapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;




public class SixthActivity extends AppCompatActivity
{
    private TextToSpeech tts;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(200, 200));    // Set button size
        button.setBackgroundColor(Color.rgb(0, 0, 255));               // Blue button


        // Gets actual display width and height

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;


        float buttonRemoveTranslationX = width - 200;
        float buttonRemoveTranslationY = height / 18f;


        // Set button position

        button.setX(buttonRemoveTranslationX);
        button.setY(buttonRemoveTranslationY);

        setContentView(button);                     // Adds the button to view so we can see it




        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the blue button twice";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });




        // Going back to GT

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");


                // Google Translate is installed on device - launch it

                if (gtIntent != null)
                {
                    startActivity(gtIntent);

                    Handler handler = new Handler();


                    // Wait 3 seconds before going back to 1st activity

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run() {
                            Intent firstActivityIntent = new Intent(getApplicationContext(), FirstActivity.class);
                            startActivity(firstActivityIntent);
                        }
                    }, 3000);
                }
            }
        });
    }
}