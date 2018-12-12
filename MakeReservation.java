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
        //setRoom(1);
    }

    public void setRoom(int roomNum) {
        rooms[roomNum] = !(rooms[roomNum]);
        setRoomTimer(getApplicationContext());
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

    protected Timer roomTimer;

    public void setRoomTimer(Context context) {
        final TextView timeLeft = (TextView) ((MakeReservation) context).findViewById(R.id.timeLeft);
        new CountDownTimer(3600000, 0) {
            public void onTick(long millUntilDone) {
                long calculateTime = (millUntilDone / 60000);
                timeLeft.setText(String.valueOf(calculateTime));
            }

            public void onFinish() {
                timeLeft.setText("Time's up!");
            }
        }.start();
    }
}
