package com.example.connorparnell.libraryroomreservations;

import android.os.Bundle;
import java.util.ArrayList;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MakeReservation extends AppCompatActivity {
    protected int numRooms = 10;

    public boolean rooms[] = new boolean[numRooms];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_screen);

        TextView countDownText = findViewById(R.id.timeLeft);

        countDownText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setRoomTimer();
            }
        });
    }

    /*public void setRoom() {
        rooms[0] = !(rooms[0]);
        setRoomTimer(getApplicationContext());
    }*/

    CountDownTimer timer;
    long timeLeftMill;
    TextView timeLeft;

    public void setRoomTimer() {
        timeLeft = findViewById(R.id.timeLeft);
        timer = new CountDownTimer(3600000, 1000) {
            public void onTick(long millUntilDone) {
                timeLeftMill = millUntilDone;
                updateTimer();
            }

            public void onFinish() {
                timeLeft.setText("Time's up!");
                stopTimer();
            }
        }.start();
    }

    public void updateTimer() {
        int mins = (int) timeLeftMill / 60000;
        int sec = (int) timeLeftMill % 60000 / 1000;

        String timeLeftText;

        timeLeftText = mins + ":";

        if (sec < 10) {
            timeLeftText += "0";
        } else {
            timeLeftText += sec;
        }

        timeLeft.setText(timeLeftText);
    }

    public void stopTimer() {
        timer.cancel();
    }

    public void setAllRooms() {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = false;
        }
    }

    public ArrayList findEmptyRooms() {
        ArrayList<Integer> emptyRooms = new ArrayList();
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == false) {
                emptyRooms.add(i);
            }
        }

        return emptyRooms;
    }

}
