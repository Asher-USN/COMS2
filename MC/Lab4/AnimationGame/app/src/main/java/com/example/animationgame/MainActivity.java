package com.example.animationgame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;



public class MainActivity extends Activity {
	int x=500,y=20;
	int gx=100,gy=100;
	int yx=300,yy=50;
	private int height =0;
	private boolean up1;
	private boolean up2;
	private boolean up3;

	Bitmap myImage,myImage2,myImage3;

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
		myImage= BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		Bitmap b1 = BitmapFactory.decodeResource(getResources(), R.drawable.ball1);
		Bitmap b2 = BitmapFactory.decodeResource(getResources(), R.drawable.ball2);
		int size = 200;

		myImage2 = Bitmap.createScaledBitmap(b1, size, size, true);
		myImage3 = Bitmap.createScaledBitmap(b2, size, size, true);
		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
	}


	public void doDraw(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED);
		canvas.drawBitmap(myImage, x, y, paint);
		paint.setColor(Color.GREEN);
		canvas.drawBitmap(myImage2, gx, gy, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawBitmap(myImage3, yx, yy, paint);
		if (!up1) {
			y = y - 10;
			if (y <= 0) {
				up1 = true;
			}
		} else {
			y = y + 10;
			if (height <= y) {
				up1 = false;
			}
		}

		if (!up2) {
			gy = gy - 20;
			if (y <= 0) {
				up2 = true;
			}
		} else {
			gy = gy + 20;
			if (height <= gy) {
				up2 = false;
			}
		}

		if (!up3) {
			yy = yy - 15;
			if (yy <= 0) {
				up3 = true;
			}
		} else {
			yy = yy + 15;
			if (height <= y) {
				up3 = false;
			}
		}
	}
}
