package pegueupombo;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rects extends Retangulo {
	
	Bitmap pombo;
	public Rects(int x, int y, Resources res, Context context) {
		super(x, y, 20, 20);
		InputStream is;
		try {
			is = context.getAssets().open("pombo.png");
			pombo = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

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
		canvas.drawBitmap(pombo, getX(), getY(), paint);
	}
}
