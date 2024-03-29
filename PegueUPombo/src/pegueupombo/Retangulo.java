package pegueupombo;

public class Retangulo {
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Retangulo(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean colide(Retangulo r) {
		if (r.getX()>x+width) return false;
		if (r.getY() > y +height) return false;
		if (r.getX()+r.getWidth()<x) return false;
		if (r.getY()+r.getHeight()<y) return false;
		return true;
	}
	public boolean colide(int x2, int y2) {
		if (x2>x+width) return false;
		if (y2>y+height) return false;
		if (x2<x) return false;
		if (y2<y) return false;
		return true;
	}
}
