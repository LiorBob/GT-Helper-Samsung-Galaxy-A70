package com.example.user.firstbuttonapp;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Locale;



public class FourthActivity extends AppCompatActivity
{
    private TextToSpeech tts;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(200, 200));    // Set button size
        button.setBackgroundColor(Color.rgb(255, 0, 0));               // Red button





        // Gets actual display width and height

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;


        float buttonExchangeLanguageX = width - 350;
        float buttonExchangeLanguageY = height - 350;




        // Set button position

        button.setX(buttonExchangeLanguageX);
        button.setY(buttonExchangeLanguageY);

        setContentView(button);                     // Adds the button to view so we can see it


        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the red button twice";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });





        // Return back to GT - Clear clipboard before copy new text to it (get rid of old text)

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData data = ClipData.newPlainText("", "");
                clipboard.setPrimaryClip(data);



                Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");

                if (gtIntent != null)
                {
                    startActivity(gtIntent);



                    // Wait 2 seconds before translation copied

                    Handler handler = new Handler();

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


                            if (clipboard != null)
                            {
                                ClipData cd = clipboard.getPrimaryClip();



                                // get the translated text from Clipboard and read it in Polish Male voice

                                if (cd != null)
                                {
                                    CharSequence result = cd.getItemAt(0).getText();


                                    if (TextUtils.isEmpty(result))
                                    {
                                        Intent fourthActivityIntent = new Intent(getApplicationContext(), FourthActivity.class);
                                        startActivity(fourthActivityIntent);
                                    }

                                    else        // Copy text succeeded
                                    {
                                        Voice polishMaleVoice = new Voice("pl-pl-x-oda#male_1-local", new Locale("pl", "PL"), 400, 200, true, null);
                                        tts.setVoice(polishMaleVoice);
                                        tts.speak(result, TextToSpeech.QUEUE_FLUSH, null, null);



                                        // After starting speaking - shows new blank screen  for swipe down

                                        Intent fifthActivityIntent = new Intent(getApplicationContext(), FifthActivity.class);
                                        startActivity(fifthActivityIntent);
                                    }
                                }
                            }
                        }
                    }, 2000);
                }
            }
        });
    }
}
