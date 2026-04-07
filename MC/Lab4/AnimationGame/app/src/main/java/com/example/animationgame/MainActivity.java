package com.example.animationgame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity implements View.OnTouchListener {
    ArrayList<Ball> balls = new ArrayList<>();

    Ball b1;
    Ball b2;
    Ball b3;
    DrawView drawView;
    private double height = 0;
    private double width = 0;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set full screen view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        @SuppressLint({"NewApi", "LocalSuppress"}) WindowMetrics windowMetrics = getWindowManager().getCurrentWindowMetrics();

        height = windowMetrics.getBounds().height();
        width = windowMetrics.getBounds().width();
        b1 = new Ball(500, 20, 2, 0, width, height);
        b2 = new Ball(100, 100, 3, 0, width, height);
        b3 = new Ball(300, 50, 1, 0, width, height);
        balls.add(b1);
        balls.add(b2);
        balls.add(b3);


        drawView = new DrawView(this);
        setContentView(drawView);
        drawView.requestFocus();

        drawView.setOnTouchListener(this);
    }


    public void doDraw(Canvas canvas, Paint paint) {
        for (Ball b : balls) {
            paint.setColor(Color.RED);
            b.update(0.5);
            canvas.drawCircle((int) b.x, (int) b.y, 30, paint);
        }

    }

    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {

        float touched = arg1.getX();
        if (touched > (width / 2)) {
            b1.y = 50;
            b2.y = 50;
            b3.y = 50;
            b1.xspeed *= -1;
            b2.xspeed *= -1;
            b3.xspeed *= -1;
            Random random = new Random();

            @SuppressLint({"NewApi", "LocalSuppress"}) double randHeight = random.nextDouble(height);
            @SuppressLint({"NewApi", "LocalSuppress"}) double randWidth = random.nextDouble(width);
            Ball bNew = new Ball(randWidth, randHeight, 0, 0, width, height);
            balls.add(bNew);

        }
        if (touched < (width / 2)) {
            balls.clear();
        }
        return false;
    }
}
