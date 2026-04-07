package com.example.animationgame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

	int x=500,y=20;
	int gx=100,gy=100;
	int yx=300,yy=50;
	private double height =0;
	private double width =0;
	//private boolean up1;
	//private boolean up2;
	//private boolean up3;

//	Bitmap myImage,myImage1,myImage2;

	DrawView drawView;


	@SuppressLint("NewApi")
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set full screen view
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		@SuppressLint({"NewApi", "LocalSuppress"}) WindowMetrics windowMetrics = getWindowManager().getCurrentWindowMetrics();

		height = windowMetrics.getBounds().height();
		width = windowMetrics.getBounds().width();
		b1 = new Ball (500 , 20 , 2 , 0 , width , height) ;
		b2 = new Ball (100 , 100 , 3 , 0 , width , height) ;
		b3 = new Ball (300 , 50 , 1 , 0 , width , height) ;
		balls.add(b1);
		balls.add(b2);
		balls.add(b3);
		//myImage= BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		//myImage1 = BitmapFactory.decodeResource(getResources(), R.drawable.ball1);
		//myImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.ball2);

		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();

		drawView.setOnTouchListener(this);
	}


	public void doDraw(Canvas canvas, Paint paint) {
		for(Ball b :balls){
			paint.setColor(Color.RED);
			b.update(0.5);
			canvas.drawCircle((int) b.x, (int) b.y, 30, paint);
		}
		/*
		paint.setColor(Color.RED);
		canvas.drawCircle((int) b1.x, (int) b1.y, 30, paint);
		b1.update(0.5);

		//canvas.drawBitmap(myImage, x, y, paint);
		paint.setColor(Color.GREEN);
		canvas.drawCircle((int) b2.x, (int) b2.y, 20, paint);
		b2.update(0.5);
		//canvas.drawBitmap(myImage1, gx, gy, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawCircle((int) b3.x, (int) b3.y, 10, paint);
		b3.update(0.5);
		//canvas.drawBitmap(myImage2, yx, yy, paint);


		 */
		/*if (!up1) {
			y = y - 10;
			if (y - 150 <= 0) {
				up1 = true;
			}
		} else {
			y = y + 10;
			if (height <= y +150) {
				up1 = false;
			}
		}

		if (!up2) {
			gy = gy - 20;
			if (gy - 130 <= 0) {
				up2 = true;
			}
		} else {
			gy = gy + 20;
			if (height <= gy + 130) {
				up2 = false;
			}
		}

		if (!up3) {
			yy = yy - 15;
			if (yy -110 <= 0) {
				up3 = true;
			}
		} else {
			yy = yy + 15;
			if (height <= yy + 110) {
				up3 = false;
			}
		}
	}
	*/
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {

		float touched = arg1.getX();
		if(touched > (width/2)){
			b1.y = 50;
			b2.y = 50;
			b3.y = 50;
			b1.xspeed *= -1;
			b2.xspeed *= -1;
			b3.xspeed *= -1;
			Random random = new Random();

			@SuppressLint({"NewApi", "LocalSuppress"}) double randHeight = random.nextDouble(height);
			@SuppressLint({"NewApi", "LocalSuppress"}) double randWidth = random.nextDouble(width);
			Ball bNew = new Ball(randWidth,randHeight,0,0,width,height);
			balls.add(bNew);

		}
		if(touched<(width/2)){
			balls.clear();
		}
		return false;
	}
}
