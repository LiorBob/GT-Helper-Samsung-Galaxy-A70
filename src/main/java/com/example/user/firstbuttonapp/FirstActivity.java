package com.example.user.firstbuttonapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;



public class FirstActivity extends AppCompatActivity
{
    private TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        Button button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(300, 300));    // Set button size
        button.setBackgroundColor(Color.rgb(255, 140, 0));              // Set button bg by rgb values



        // Check device orientation - if hold vertical or horizontal and set button position accordingly

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT)              // Vertical
        {
            button.setX(60);
            button.setY(380);
        }

        else                                                                // Horizontal
        {
            button.setX(560);
            button.setY(380);
        }



        setContentView(button);                     // Adds the button to view so we can see it





        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the orange button twice";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });






        // Launch GT on button click

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




                    // Wait 3 seconds until Focus camera instruction is begin heard

                    /* handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Focus the camera";
                            tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
                        }
                    }, 3000); */




                    // Wait 3 seconds until 2nd activity is shown up  with new button

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent secondActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                            startActivity(secondActivityIntent);
                        }
                    }, 3000);

                }

            }
        });
    }
}


