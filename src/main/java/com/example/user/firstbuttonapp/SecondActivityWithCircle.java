package com.example.user.firstbuttonapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;




public class SecondActivityWithCircle extends AppCompatActivity
{
    private TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        FloatingActionButton circleButton = new FloatingActionButton(this);             // Create new circle button
        circleButton.setLayoutParams(new LinearLayout.LayoutParams(200, 200));    // Set button size




        // Gets actual display width and height

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;




        // Set button position

        float buttonCameraX = width / 2 - 100;
        float buttonCameraY = height - 200 * 2.5f;

        circleButton.setX(buttonCameraX);
        circleButton.setY(buttonCameraY);

        setContentView(circleButton);                     // Adds the circle button to view so we can see it */





        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the red circle";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });







        // Return back to GT - pressing this button click will bring us back to the camera in GT

        circleButton.setOnClickListener(new View.OnClickListener()
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


                    // Wait 1 second until next notification is being heard

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String textToSpeak = "Press the white";
                            tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }, 1000);



                    // Wait 2 seconds before moving to the activity with ellipse

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent secondActivityWithEllipseIntent = new Intent(getApplicationContext(), SecondActivityWithEllipse.class);
                            startActivity(secondActivityWithEllipseIntent);
                        }
                    }, 3000);

                }
            }
        });
    }
}
