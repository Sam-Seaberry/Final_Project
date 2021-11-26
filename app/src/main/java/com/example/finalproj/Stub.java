package com.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import android.os.Bundle;
import android.widget.TextView;

public class Stub extends AppCompatActivity {

    int db = 10;
    int feq = 0;

    int place = 0;

    int[] logs = new int[20];


    int [][] tones = {{R.raw.s30_db0,R.raw.s30_db3,R.raw.s30_db6,R.raw.s30_db9,R.raw.s30_db12,R.raw.s30_db15,R.raw.s30_db18,R.raw.s30_db21,R.raw.s30_db24,R.raw.s30_db27,R.raw.s30_db30,R.raw.s30_db33,R.raw.s30_db36,R.raw.s30_db39,R.raw.s30_db42,R.raw.s30_db45,R.raw.s30_db48,R.raw.s30_db51,R.raw.s30_db54,R.raw.s30_db57,R.raw.s30_db69},
            {R.raw.s45_db0,R.raw.s45_db3,R.raw.s45_db6,R.raw.s45_db9,R.raw.s45_db12,R.raw.s45_db15,R.raw.s45_db18,R.raw.s45_db21,R.raw.s45_db24,R.raw.s45_db27,R.raw.s45_db30,R.raw.s45_db33,R.raw.s45_db36,R.raw.s45_db39,R.raw.s45_db42,R.raw.s45_db45,R.raw.s45_db48,R.raw.s45_db51,R.raw.s45_db54,R.raw.s45_db57,R.raw.s45_db60},
            {R.raw.s60_db0,R.raw.s60_db3,R.raw.s60_db6,R.raw.s60_db9,R.raw.s60_db12,R.raw.s60_db15,R.raw.s60_db18,R.raw.s60_db21,R.raw.s60_db24,R.raw.s60_db27,R.raw.s60_db30,R.raw.s60_db33,R.raw.s60_db36,R.raw.s60_db39,R.raw.s60_db42,R.raw.s60_db45,R.raw.s60_db48,R.raw.s60_db51,R.raw.s60_db54,R.raw.s60_db57,R.raw.s60_db60},
            {R.raw.s90_db0,R.raw.s90_db3,R.raw.s90_db6,R.raw.s90_db9,R.raw.s90_db12,R.raw.s90_db15,R.raw.s90_db18,R.raw.s90_db21,R.raw.s90_db24,R.raw.s90_db27,R.raw.s90_db30,R.raw.s90_db33,R.raw.s90_db36,R.raw.s90_db39,R.raw.s90_db42,R.raw.s90_db45,R.raw.s90_db48,R.raw.s90_db51,R.raw.s90_db54,R.raw.s90_db57,R.raw.s90_db60},
            {R.raw.s125_db0,R.raw.s125_db3,R.raw.s125_db6,R.raw.s125_db9,R.raw.s125_db12,R.raw.s125_db15,R.raw.s125_db18,R.raw.s125_db21,R.raw.s125_db24,R.raw.s125_db27,R.raw.s125_db30,R.raw.s125_db33,R.raw.s125_db36,R.raw.s125_db39,R.raw.s125_db42,R.raw.s125_db45,R.raw.s125_db48,R.raw.s125_db51,R.raw.s125_db54,R.raw.s125_db57,R.raw.s125_db60},
            {R.raw.s187_db0,R.raw.s187_db3,R.raw.s187_db6,R.raw.s187_db9,R.raw.s187_db12,R.raw.s187_db15,R.raw.s187_db18,R.raw.s187_db21,R.raw.s187_db24,R.raw.s187_db27,R.raw.s187_db30,R.raw.s187_db33,R.raw.s187_db36,R.raw.s187_db39,R.raw.s187_db42,R.raw.s187_db45,R.raw.s187_db48,R.raw.s187_db51,R.raw.s187_db54,R.raw.s187_db57,R.raw.s187_db60},
            {R.raw.s250_db0,R.raw.s250_db3,R.raw.s250_db6,R.raw.s250_db9,R.raw.s250_db12,R.raw.s250_db15,R.raw.s250_db18,R.raw.s250_db21,R.raw.s250_db24,R.raw.s250_db27,R.raw.s250_db30,R.raw.s250_db33,R.raw.s250_db36,R.raw.s250_db39,R.raw.s250_db42,R.raw.s250_db45,R.raw.s250_db48,R.raw.s250_db51,R.raw.s250_db54,R.raw.s250_db57,R.raw.s250_db60},
            {R.raw.s375_db0,R.raw.s375_db3,R.raw.s375_db6,R.raw.s375_db9,R.raw.s375_db12,R.raw.s375_db15,R.raw.s375_db18,R.raw.s375_db21,R.raw.s375_db24,R.raw.s375_db27,R.raw.s375_db30,R.raw.s375_db33,R.raw.s375_db36,R.raw.s375_db39,R.raw.s375_db42,R.raw.s375_db45,R.raw.s375_db48,R.raw.s375_db51,R.raw.s375_db54,R.raw.s375_db57,R.raw.s375_db60},
            {R.raw.s500_db0,R.raw.s500_db3,R.raw.s500_db6,R.raw.s500_db9,R.raw.s500_db12,R.raw.s500_db15,R.raw.s500_db18,R.raw.s500_db21,R.raw.s500_db24,R.raw.s500_db27,R.raw.s500_db30,R.raw.s500_db33,R.raw.s500_db36,R.raw.s500_db39,R.raw.s500_db42,R.raw.s500_db45,R.raw.s500_db48,R.raw.s500_db51,R.raw.s500_db54,R.raw.s500_db57,R.raw.s500_db60},
            {R.raw.s750_db0,R.raw.s750_db3,R.raw.s750_db6,R.raw.s750_db9,R.raw.s750_db12,R.raw.s750_db15,R.raw.s750_db18,R.raw.s750_db21,R.raw.s750_db24,R.raw.s750_db27,R.raw.s750_db30,R.raw.s750_db33,R.raw.s750_db36,R.raw.s750_db39,R.raw.s750_db42,R.raw.s750_db45,R.raw.s750_db48,R.raw.s750_db51,R.raw.s750_db54,R.raw.s750_db57,R.raw.s750_db60},
            {R.raw.s1_db0,R.raw.s1_db3,R.raw.s1_db6,R.raw.s1_db9,R.raw.s1_db12,R.raw.s1_db15,R.raw.s1_db18,R.raw.s1_db21,R.raw.s1_db24,R.raw.s1_db27,R.raw.s1_db30,R.raw.s1_db33,R.raw.s1_db36,R.raw.s1_db39,R.raw.s1_db42,R.raw.s1_db45,R.raw.s1_db48,R.raw.s1_db51,R.raw.s1_db54,R.raw.s1_db57,R.raw.s1_db60},
            {R.raw.s1_5_0db,R.raw.s1_5_3db,R.raw.s1_5_6db,R.raw.s1_5_9db,R.raw.s1_5_12db,R.raw.s1_5_15db,R.raw.s1_5_18db,R.raw.s1_5_21db,R.raw.s1_5_24db,R.raw.s1_5_27db,R.raw.s1_5_30db,R.raw.s1_5_33db,R.raw.s1_5_36db,R.raw.s1_5_39db,R.raw.s1_5_42db,R.raw.s1_5_45db,R.raw.s1_5_48db,R.raw.s1_5_51db,R.raw.s1_5_54db,R.raw.s1_5_57db,R.raw.s1_5_60db},
            {R.raw.s2_db0,R.raw.s2_db3,R.raw.s2_db6,R.raw.s2_db9,R.raw.s2_db12,R.raw.s2_db15,R.raw.s2_db18,R.raw.s2_db21,R.raw.s2_db24,R.raw.s2_db27,R.raw.s2_db30,R.raw.s2_db33,R.raw.s2_db36,R.raw.s2_db39,R.raw.s2_db42,R.raw.s2_db45,R.raw.s2_db48,R.raw.s2_db51,R.raw.s2_db54,R.raw.s2_db57,R.raw.s2_db60},
            {R.raw.s3_db0,R.raw.s3_db3,R.raw.s3_db6,R.raw.s3_db9,R.raw.s3_db12,R.raw.s3_db15,R.raw.s3_db18,R.raw.s3_db21,R.raw.s3_db24,R.raw.s3_db27,R.raw.s3_db30,R.raw.s3_db33,R.raw.s3_db36,R.raw.s3_db39,R.raw.s3_db42,R.raw.s3_db45,R.raw.s3_db48,R.raw.s3_db51,R.raw.s3_db54,R.raw.s3_db57,R.raw.s3_db60},
            {R.raw.s4_db0,R.raw.s4_db3,R.raw.s4_db6,R.raw.s4_db9,R.raw.s4_db12,R.raw.s4_db15,R.raw.s4_db18,R.raw.s4_db21,R.raw.s4_db24,R.raw.s4_db27,R.raw.s4_db30,R.raw.s4_db33,R.raw.s4_db36,R.raw.s4_db39,R.raw.s4_db42,R.raw.s4_db45,R.raw.s4_db48,R.raw.s4_db48,R.raw.s4_db54,R.raw.s4_db57,R.raw.s4_db69},
            {R.raw.s6_db0,R.raw.s6_db3,R.raw.s6_db6,R.raw.s6_db9,R.raw.s6_db12,R.raw.s6_db15,R.raw.s6_db18,R.raw.s6_db21,R.raw.s6_db24,R.raw.s6_db27,R.raw.s6_db30,R.raw.s6_db33,R.raw.s6_db36,R.raw.s6_db39,R.raw.s6_db42,R.raw.s6_db45,R.raw.s6_db48,R.raw.s6_db51,R.raw.s6_db54,R.raw.s6_db57,R.raw.s6_db60},
            {R.raw.s8_db0,R.raw.s8_db3,R.raw.s8_db9,R.raw.s8_db9,R.raw.s8_db12,R.raw.s8_db15,R.raw.s8_db18,R.raw.s8_db21,R.raw.s8_db24,R.raw.s8_db27,R.raw.s8_db30,R.raw.s8_db33,R.raw.s8_db36,R.raw.s8_db39,R.raw.s8_db42,R.raw.s8_db45,R.raw.s8_db48,R.raw.s8_db51,R.raw.s8_db54,R.raw.s8_db57,R.raw.s8_db60},
            {R.raw.s12_db0,R.raw.s12_db3,R.raw.s12_db6,R.raw.s12_db9,R.raw.s12_db12,R.raw.s12_db15,R.raw.s12_db18,R.raw.s12_db21,R.raw.s12_db24,R.raw.s12_db27,R.raw.s12_db30,R.raw.s12_db33,R.raw.s12_db36,R.raw.s12_db39,R.raw.s12_db42,R.raw.s12_db45,R.raw.s12_db48,R.raw.s12_db51,R.raw.s12_db54,R.raw.s12_db57,R.raw.s12_db60},
            {R.raw.s16_db0,R.raw.s16_db3,R.raw.s16_db6,R.raw.s16_db9,R.raw.s16_db12,R.raw.s16_db15,R.raw.s16_db18,R.raw.s16_db21,R.raw.s16_db24,R.raw.s16_db27,R.raw.s16_db30,R.raw.s16_db33,R.raw.s16_db36,R.raw.s16_db39,R.raw.s16_db42,R.raw.s16_db45,R.raw.s16_db48,R.raw.s16_db51,R.raw.s16_db54,R.raw.s16_db57,R.raw.s16_db60}
    };

    MediaPlayer mp, ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tunes);

        Button equals = (Button) findViewById(R.id.button);
        Button quite = (Button) findViewById(R.id.button2);
        Button loud = (Button) findViewById(R.id.button3);
        Button start = (Button) findViewById(R.id.button5);




        mp = MediaPlayer.create(this,tones[feq][db]);
        ref = MediaPlayer.create(this, R.raw.s750_db30);

    }

    public void quite(View v)
    {
        release();


        ref = MediaPlayer.create(this, R.raw.s750_db30);
        ref.start();
        SystemClock.sleep(300);

        if(db <20){
            db++;
        }


        mp = MediaPlayer.create(this, tones[feq][db]);
        mp.start();
    }


    public void loud(View v)
    {
        release();
        TextView txtt = (TextView) findViewById(R.id.textView5);
        ref = MediaPlayer.create(this, R.raw.s750_db30);
        ref.start();
        SystemClock.sleep(300);

        if(db >0){
            db--;
        }
        else{
            txtt.setVisibility(View.VISIBLE);
        }

        mp = MediaPlayer.create(this, tones[feq][db]);
        mp.start();
    }


    public void equal(View v)
    {
        TextView txtt = (TextView) findViewById(R.id.textView5);
        txtt.setVisibility(View.INVISIBLE);
        release();
        logs[place] = db;
        place++;


        ref = MediaPlayer.create(this, R.raw.s750_db30);
        ref.start();
        SystemClock.sleep(300);

        if(feq < 18){
            feq++;
        }
        else{
            TextView txt = (TextView) findViewById(R.id.textView6);
            txt.setVisibility(View.VISIBLE);

            Intent intent = new Intent(Stub.this, graph.class);
            intent.putExtra("logs",logs);
            startActivity(intent);
        }

        db = 10;

        mp = MediaPlayer.create(this, tones[feq][db]);
        mp.start();
    }
    public void start(View v)
    {
        Button start = (Button) findViewById(R.id.button5);
        start.setVisibility(View.GONE);

        ref.start();
        SystemClock.sleep(300);

        mp.start();
    }
    public void end(){




    }
    public void release(){
        mp.release();
        ref.release();
    }



}
