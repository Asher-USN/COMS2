package com.example.animationgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View{
    MainActivity parent;
    Paint paint = new Paint();

    public DrawView(MainActivity s) {
        super(s);
        parent = s;
        setFocusable(true);
        setBackgroundColor(Color.parseColor("#000033"));
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }
    
    @Override
    public void onDraw(Canvas canvas) {
    	parent.doDraw(canvas, paint);
		try {  
	         Thread.sleep(10);  
	      } catch (InterruptedException e) { }
	      invalidate();
    }
}

