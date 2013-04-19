package pegueupombo;

import unifran.ely.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements Runnable {
	private final static int INTERVAL = 700;
	private boolean running = true;
	private Paint paint;
	private Rects inimigos;
	private int pontos = 0;
	private boolean jogoIniciado = false;
	private Bitmap bmpFundo;
	Context context;
	
	public GameView(Context context) {
		super(context);
		
		this.context = context;
		paint = new Paint();
		Thread minhaThread = new Thread(this);
		minhaThread.setPriority(Thread.MIN_PRIORITY);
		minhaThread.start();
	}
	
	public void iniciaJogo() {
		
		int y = (int) (Math.random()*(getHeight()-25));
		int x = (int) (Math.random()*(getWidth()-25));
		inimigos =  new Rects(x, y, getResources(), this.context);
		
		bmpFundo = BitmapFactory.decodeResource(getResources(), R.drawable.fundo);
		bmpFundo = Bitmap.createScaledBitmap(bmpFundo, getWidth(), getHeight(), true);
		
		jogoIniciado = true;
	}

	public void run() {
		while (running) {
			try {
				Thread.sleep(INTERVAL);
			} catch (Exception e) {
				Log.e("Jogo", "Sleep da Thread");
			}
			update();
		}
	}
			
	private void update() 
	{
		if (jogoIniciado==false) {
			return;
		}
		inimigos.mover(getHeight(), getWidth());

		postInvalidate();
	}
	
	public void draw(Canvas canvas) {
		super.draw(canvas);
		
		if (jogoIniciado==false) {
			iniciaJogo();
		}
		
		canvas.drawBitmap(bmpFundo, 0, 0, paint);
	
		paint.setColor(Color.RED);
		inimigos.draw(canvas, paint);
		
		paint.setColor(Color.BLACK);
		paint.setTextSize(20);
		canvas.drawText("Pontos: " + pontos, 0, 20, paint);
		
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		if (action == MotionEvent.ACTION_DOWN) 
		{
			if (inimigos.colide(x, y)) 
			{
				inimigos.mover(getHeight(), getWidth());
				pontos ++;
			}
		
		} else if (action==MotionEvent.ACTION_UP) {

		} else if (action==MotionEvent.ACTION_MOVE) {
			
		}
		
		return super.onTouchEvent(event);
	}
	
	public void release() {
		running = false;
	}
	
}
