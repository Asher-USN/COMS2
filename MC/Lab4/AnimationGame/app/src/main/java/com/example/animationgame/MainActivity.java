package com.example.animationgame;

import android.annotation.SuppressLint;
import android.app.Activity;
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

		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
	}


	public void doDraw(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED);
		canvas.drawCircle(x, y, 70, paint);
		paint.setColor(Color.GREEN);
		canvas.drawCircle(gx, gy, 30, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawCircle(yx, yy, 10, paint);
		if(y>height){
			y=0;
		}else {
			y = y + 10;
		}
		if(yy>height){
			yy=0;
		}else {
			yy = yy + 15;
		}
		if(gy>height){
			gy=0;
		}else {
			gy = gy + 20;
		}
	}

}
