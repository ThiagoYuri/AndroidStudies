package com.example.musicflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivityGerenciarMusica extends AppCompatActivity {


    private MediaPlayer mp1, mp2, mp3;
    private boolean play;
    ContentValues valuesInseir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gerenciar_musica);

        //musica
        mp1 = MediaPlayer.create(this,R.raw.baruk);
        mp2 = MediaPlayer.create(this,R.raw.tuessoberano);
        mp3 = MediaPlayer.create(this,R.raw.ministrio);




    }




    public void musicaPlay(View v) {


        play = mp1.isPlaying();


        if (play) {
            mp1.pause();

        } else if (mp1.getDuration() != 0) {

            mp1 = MediaPlayer.create(this, R.raw.baruk);
            mp1.start();




            // Toast.makeText(this, ""+, Toast.LENGTH_SHORT).show();

        } else {
            mp3.start();
            mp2.start();
            mp1 = MediaPlayer.create(this, R.raw.baruk);
            mp1.start();


        }

    }
    public void musicaPlay2(View v) {




    }
    public void musicaPlay3(View v) {




    }

}
