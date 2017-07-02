package com.example.gabri.patmos;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;


public class Principal_Fragment extends Fragment{

    Context context;
    boolean prepared;
    boolean started = false;
    float volume = 50;

    private String urlStream = "http://stm47.srvstm.com:16890/;";
    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context = container.getContext();
        View view =  (LinearLayout) inflater.inflate( R.layout.activity_principal, container, false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        new PlayerTask().execute(urlStream);

        ImageButton button = (ImageButton) view.findViewById(R.id.buttonPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!started){

                    started = true;
                    mediaPlayer.start();
                    Toast.makeText(context, "Iniciado", Toast.LENGTH_SHORT).show();
                }
           }
        });

        ImageButton buttonPause = (ImageButton) view.findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started){

                    started = false;
                    mediaPlayer.pause();
                    Toast.makeText(context, "Pausado", Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }


    class PlayerTask extends AsyncTask<String, Void, Boolean>{

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            //mediaPlayer.start();
        }

        
    }
}
