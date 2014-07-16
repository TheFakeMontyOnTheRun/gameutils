package br.odb.utils;

public class Color {

	private int r;
	private int g;
	private int b;
	private int a;

	public Color(int argb) {

		a = argb >> 24 & 0xFF;
		r = (argb & 0x00FF0000) >> 16;
		g = (argb & 0x0000FF00) >> 8;
		b = ((argb & 0x000000FF));
	}

	// ------------------------------------------------------------------------------------------------------------

	public Color(int r, int g, int b, int a) {
		this.setR(r);
		this.setG(g);
		this.setB(b);
		this.setA(a);
	}

	public Color() {
		this(0, 0, 0, 255);
	}

	public Color(int r, int g, int b) {
		this(r, g, b, 255);
	}

	public Color(Color c) {
		this(c.r, c.g, c.b, c.a);
	}

	public Color(float r, float g, float b) {
		this.r = (int) (r * 255);
		this.g = (int) (g * 255);
		this.b = (int) (b * 255);
		this.a = 255;
	}

	public Color(float r2, float g2, float b2, float a2) {
		this(r2, g2, b2);
		a = (int) (255 * a2);
	}

	/**
	 * @param r
	 *            the r to set
	 */
	public void setR(int r) {
		this.r = Utils.clamp(r, 0, 255);
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param g
	 *            the g to set
	 */
	public void setG(int g) {
		this.g = Utils.clamp(g, 0, 255);
	}

	/**
	 * @return the g
	 */
	public int getG() {
		return g;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = Utils.clamp(b, 0, 255);
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public Color setA(int a) {
		this.a = Utils.clamp(a, 0, 255);

		return this;
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		String hex;

		hex = Integer.toString(r);
		sb.append(hex);
		sb.append(" ");

		hex = Integer.toString(g);
		sb.append(hex);
		sb.append(" ");

		hex = Integer.toString(b);
		sb.append(hex);
		sb.append(" ");

		hex = Integer.toString(a);
		sb.append(hex);

		return sb.toString();
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
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + g;
		result = prime * result + r;
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
		if (!(obj instanceof Color)) {
			return false;
		}
		Color other = (Color) obj;
		if (a != other.a) {
			return false;
		}
		if (b != other.b) {
			return false;
		}
		if (g != other.g) {
			return false;
		}
		if (r != other.r) {
			return false;
		}
		return true;
	}

	public int getARGBColor() {

		int color = 0;
		color = (a & 0xFF) << 24;
		color += (r & 0xFF) << 16;
		color += (g & 0xFF) << 8;
		color += b;

		return color;

	}

	public void set(int r, int g, int b, int a) {
		setA(a);
		setR(r);
		setG(g);
		setB(b);
	}

	public void set(int r, int g, int b) {
		set(r, g, b, 255);
	}

	public static Color getColorFromHTMLColor(String htmlColor) {
		Color toReturn = new Color();

		toReturn.setR(Integer.parseInt(htmlColor.substring(1, 3), 16));
		toReturn.setG(Integer.parseInt(htmlColor.substring(3, 5), 16));
		toReturn.setB(Integer.parseInt(htmlColor.substring(5, 7), 16));
		toReturn.setA(255);

		return toReturn;
	}

	public String getHTMLColor() {
		// 0x100 makes sure we have a 3 digit number, promptly culled with the
		// substring(1).
		String rHex = Integer.toString((r & 0xff) + 0x100, 16).substring(1);
		String gHex = Integer.toString((g & 0xff) + 0x100, 16).substring(1);
		String bHex = Integer.toString((b & 0xff) + 0x100, 16).substring(1);
		return "#" + rHex + gHex + bHex;
	}

	public void set(Color color) {

		set(color.r, color.g, color.b, color.a);
	}

	public String getExplicitRGBColor() {

		return "rgb( " + r + ", " + g + ", " + b + " )";
	}

	public void multiply(float factor) {

		r = (int) (r * factor);
		g = (int) (g * factor);
		b = (int) (b * factor);
	}
}