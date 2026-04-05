package com.example.animationgame;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	int x=500,y=20;
	
	DrawView drawView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set full screen view
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
	}


	public void doDraw(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED);
		canvas.drawCircle(x, y, 70, paint);
		paint.setColor(Color.GREEN);
		canvas.drawCircle(100, 100, 30, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawCircle(300, 50, 10, paint);
		y=y+10;
	}

}
