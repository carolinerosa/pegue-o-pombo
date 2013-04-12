package com.example.testesemulador;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements Runnable 
{

	boolean running;
	public Paint paint;
	private Circulo c;
	private Random r;
	private int Radius = 45;
	int DelayMilisseconds = 2000  ;

	public GameView(Context context) {
		super(context);

		paint = new Paint();
		
		r = new Random();

		c = new Circulo((Radius*2)+50, (Radius*2)+50, Radius, paint);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);

		Thread minhaThread = new Thread(this);
		minhaThread.setPriority(Thread.MIN_PRIORITY);
		minhaThread.start();
	}

	@Override
	public void run() {

		while (running) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				Log.e("Jogo", "Sleep da Thread");
			}
			update();
			postInvalidate();
		}

	}

	private void update() 
	{
		postInvalidate();
	}

	@Override
	

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		if (action == MotionEvent.ACTION_DOWN) {
			
			c.setCx(r.nextInt(getWidth()));
			c.setCy(r.nextInt(getHeight()));
			
			Log.i(null, "getting X = " + c.getCx());
			Log.i(null, "getting Y = " + c.getCy());
			
			}
		
		
		return super.onTouchEvent(event);
	}
	
@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		paint.setColor(Color.RED);
		canvas.drawCircle(c.getCx(), c.getCy(), Radius, paint);
		
		

	}

}
