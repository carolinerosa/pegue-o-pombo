package com.example.testesemulador;

//import android.content.Context;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Paint;
//import android.util.Log;
//import android.view.View;
import android.util.Log;

public class Circulo {

	int cx;
	int cy;
	Paint pente;
	int raio;

	public Circulo(int x, int y, int raio, Paint paint) {
		this.cx = x;
		this.cy = y;
		this.raio = raio;
		this.pente = paint;
	}

	public int getCx() {
		
		Log.i(null, "getting X = " + cx);
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
		Log.i(null, "setting X = " + cx);
	}

	public int getCy() {
		
		Log.i(null, "getting X = " + cx);
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
		Log.i(null, "setting Y = " + cy);
	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(cx, cy, raio, pente);
	}

}
