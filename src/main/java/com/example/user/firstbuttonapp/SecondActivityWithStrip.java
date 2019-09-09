package com.example.user.firstbuttonapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;




public class SecondActivityWithStrip extends AppCompatActivity
{
    private TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(1000, 360));    // Set button size
        button.setBackgroundColor(Color.GREEN);                  // Green strip




        // Set button position

        button.setX(20);
        button.setY(30);

        setContentView(button);                     // Adds the button to view so we can see it





        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the strip twice";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });







        // Return back to GT - pressing this button click will bring us back to the camera in GT

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


                    // Wait 4 seconds before moving to the 3rd activity (with swipe up)

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent thirdActivityIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                            startActivity(thirdActivityIntent);
                        }
                    }, 4000);

                }

            }
        });
    }
}
