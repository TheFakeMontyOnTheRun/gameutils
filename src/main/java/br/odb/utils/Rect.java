/**
 * 
 */
package br.odb.utils;

import br.odb.utils.math.Vec2;

/**
 * @author monty
 * 
 */
public class Rect {

	public float x0;
	public float y0;
	public float x1;
	public float y1;

	public Rect(int x0, int y0, int dx, int dy) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x0 + dx;
		this.y1 = y0 + dy;
	}

	public Rect() {
		x0 = y0 = x1 = y1 = 0;
	}

	public Rect(float x0, float y0, float dx, float dy) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x0 + dx;
		this.y1 = y0 + dy;
	}

	public Rect(Rect rect) {
		this.set(rect);
	}

	public float getDX() {
		return x1 - x0;
	}

	public float getDY() {
		return y1 - y0;
	}

	public static Rect makeRectWith(int x0, int y0,
			int x1, int y1) {

		Rect rect = new Rect();

		rect.x0 = x0;
		rect.y0 = y0;
		rect.y1 = y1;
		rect.x1 = x1;

		return rect;
	}

	public Vec2 getP0() {
		return new Vec2(x0, y0);
	}

	public void setP0(Vec2 vec2) {
		x0 = vec2.x;
		y0 = vec2.y;
	}

	public void setP0(float x, float y) {
		x0 = x;
		y0 = y;
	}

	public void set(float x0, float y0, float dx, float dy) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x0 + dx;
		this.y1 = y0 + dy;
	}
	
	public boolean isInside( Vec2 point ) {
		return isInside( point.x, point.y );
	}
	
	public  boolean intersect( Rect another ) {
		
		boolean b;
		
		b = another.isInside( x0, y1 ); 
		
		if ( b ) {
			return true;
		}
		b = another.isInside( x1, y0 ); 
		
		if ( b ) {
			return true;
		}
		b = another.isInside( x1, y1 ); 
		
		if ( b ) {
			return true;
		}
		b = another.isInside( x0, y0 ); 
		
		if ( b ) {
			return true;
		}
		
//		b = ( x0 > another.x0 && x1 < another.x1 && y0 < another.y0 && y1 > another.y1 );
//		if ( b ) {
//			return true;
//		}
		
		b = isInside( another.x0, another.y1 ); 
		
		if ( b ) {
			return true;
		}
		b = isInside( another.x1, another.y0 ); 
		
		if ( b ) {
			return true;
		}
		b = isInside( another.x1, another.y1 ); 
		
		if ( b ) {
			return true;
		}
		b = isInside( another.x0, another.y0 ); 
		
		if ( b ) {
			return true;
		}
		
//		b = ( another.x0 > x0 && another.x1 < x1 && another.y0 < y0 && another.y1 > y1 );
//		
//		if ( b ) {
//			return true;
//		}
		
		return false;
	}

	public boolean isInside(float x, float y) {
		return ( x0 >= x  ) && ( y0 >= y ) && ( x <= x1 ) && ( y <= y1 );
	}

	public void set(int x0, int y0, int dx, int dy) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x0 + dx;
		this.y1 = y0 + dy;
	}

	public void set(Rect rect) {
		this.x0 = rect.x0;
		this.x1 = rect.x1;
		this.y0 = rect.y0;
		this.y1 = rect.y1;

	}

	public void setD(float dx, float dy) {
		this.x1 = this.x0 + dx;
		this.y1 = this.y0 + dy;
	}

	public void setD(int dx, int dy) {
		this.x1 = this.x0 + dx;
		this.y1 = this.y0 + dy;
	}

	public void setP1(Vec2 v) {
		x1 = v.x;
		y1 = v.y;
	}

	public void setP1(float x, float y) {
		x1 = x;
		y1 = y;
	}
}
