package br.odb.utils.math;

public class Vec2 {

	public float x;
	public float y;
	public int space;

	// ------------------------------------------------------------------------------------------------------------
	public Vec2() {
		x = 0;
		y = 0;
	}

	// ------------------------------------------------------------------------------------------------------------
	public Vec2(int i, int i0) {

		x = i;
		y = i0;
	}

	// ------------------------------------------------------------------------------------------------------------
	public Vec2(float d, float d0) {
		x = d;
		y = d0;
	}

	public Vec2(Vec2 other) {
		x = other.x;
		y = other.y;
		space = other.space;
	}

	// ------------------------------------------------------------------------------------------------------------
	public Vec2 add(Vec2 v) {

		return new Vec2(x + v.x, y + v.y);
	}

	@Override
	public String toString() {

		return "Vec2( " + x + ", " + y + " )";
	}

	public Vec2 sub(Vec2 initialPosition) {
		return new Vec2(x - initialPosition.x, y - initialPosition.y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + space;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Vec2 other = (Vec2) obj;
		if (space != other.space) {
			return false;
		}
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		return true;
	}

	public void invalidate() {
		x = Float.NaN;
		y = Float.NaN;
	}
	
	public float length() {
		return (float) Math.sqrt((x * x) + (y * y));
	}
	
	public void normalize() {

		float oneOverLen = 1 / length();
		scale(oneOverLen);
	}
	
	public Vec2 normalized() {

		Vec2 length1 = new Vec2(this);
		length1.normalize();
		return length1;
	}
	
	public boolean isValid() {
		return !Float.isNaN(x) && !Float.isNaN(y) && !Float.isInfinite(x)
				&& !Float.isInfinite(y);
	}

	public void set(Vec2 vec) {
		
		if ( Float.isNaN( vec.x ) || Float.isNaN( vec.y ) ) {
			return;
		}
		
		this.x = vec.x;
		this.y = vec.y;
		this.space = vec.space;
	}

	public void set(float x, float y) {

		this.x = x;
		this.y = y;
	}

	public void scale(float d) {

		x = x * d;
		y = y * d;
	}

	public Vec2 scaled(float f) {
		Vec2 toReturn = new Vec2(x, y);
		toReturn.scale(f);
		return toReturn;
	}

	public void addTo(Vec2 v) {
		this.x += v.x;
		this.y += v.y;
	}

	public Vec2 negated() {

		return scaled(-1.0f);
	}

	public Vec2 scaled(float width, float height) {
		Vec2 toReturn = new Vec2( this );
		toReturn.x *= width;
		toReturn.y *= height;
		return toReturn;
	}
}