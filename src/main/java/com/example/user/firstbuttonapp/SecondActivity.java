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




public class SecondActivity extends AppCompatActivity
{
    private TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(200, 200));    // Set button size
        button.setBackgroundColor(Color.rgb(0, 0, 0));      // Black button



        // Gets actual display width and height

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;




        // Set lower button position

        float buttonCameraX = width / 2 - 100;
        float buttonCameraY = height - 200 * 1.8f;

        button.setX(buttonCameraX);
        button.setY(buttonCameraY);

        setContentView(button);                     // Adds the button to view so we can see it */





        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press black button twice";
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


                if (gtIntent != null)
                {
                    startActivity(gtIntent);

                    Handler handler = new Handler();



                    // Wait 1 second before next notification is being heard

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Press the circle to scan";
                            tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }, 1000);




                    // Wait 5 seconds before next notification is being heard

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Press the white ellipse";
                            tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }, 6000);




                    // Wait 4 second before moving to the activity with strip

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent secondActivityWithStripIntent = new Intent(getApplicationContext(), SecondActivityWithStrip.class);
                            startActivity(secondActivityWithStripIntent);
                        }
                    }, 10000);
                }
            }
        });
    }
}
