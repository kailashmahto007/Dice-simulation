package com.example.dicesimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    String Text;
    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] die = {
                R.drawable.die1,
                R.drawable.die2,
                R.drawable.die3,
                R.drawable.die4,
                R.drawable.die5,
                R.drawable.die6,
        };
        Button b = findViewById(R.id.button);
        im = findViewById(R.id.imageView);


// create an object textToSpeech and adding features into it
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if (i != TextToSpeech.ERROR) {
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(6);
                int aNew = Log.d("new", " " + randomNumber);
                String t = "Roll";
                if (t.equals(b.getText())) {
                    Glide.with(MainActivity.this).asGif()
                            .load(R.drawable.die0)
                            .into((im));
                    b.setText("Stop");
                }
                else {
                    im.setImageResource(die[randomNumber]);

                    Text = "You got" + (randomNumber + 1);
                    textToSpeech.speak(Text, TextToSpeech.QUEUE_FLUSH, null);

                    b.setText("Roll");

                }


            }
        });

    }


}
