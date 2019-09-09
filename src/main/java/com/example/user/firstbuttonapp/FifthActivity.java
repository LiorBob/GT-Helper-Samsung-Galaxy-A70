package com.example.user.firstbuttonapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class FifthActivity extends AppCompatActivity
{
    private TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);




        // Directs the user to swipe down till the top of screen

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Swipe down";
                tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });





        // Return back to GT when swipe down operation detected

        View view = findViewById(android.R.id.content);


        view.setOnTouchListener(new OnSwipeTouchListener(FifthActivity.this)
        {
            @Override
            public void onSwipeDown()
            {
                super.onSwipeDown();


                Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");

                if (gtIntent != null)
                {
                    startActivity(gtIntent);

                    String textToSpeak = "And again";
                    tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);



                    // Moves to next activity after 5 seconds

                    Handler handler = new Handler();

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent sixthActivityIntent = new Intent(getApplicationContext(), SixthActivity.class);
                            startActivity(sixthActivityIntent);
                        }
                    }, 5000);

                }
            }
        });
    }
}