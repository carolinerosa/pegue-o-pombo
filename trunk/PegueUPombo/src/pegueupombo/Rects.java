package pegueupombo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rects extends Retangulo {
	
	public Rects(int x, int y, Resources res) {
		super(x, y, 20, 20);

	}
	public void mover(int height, int width) 
	{
		int x = (int) (Math.random() * (width-25));
		int y = (int) (Math.random() * (height-25));
		setX(x);
		setY(y);
	}
	public void draw(Canvas canvas, Paint paint) 
	{
		paint.setColor(Color.RED);
		canvas.drawRect(getX(),getY(),getX()+getWidth(), getY()+getHeight(),paint);
	}
}
