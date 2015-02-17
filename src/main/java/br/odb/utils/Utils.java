/**
 * 
 */
package br.odb.utils;

/**
 * @author monty
 * 
 */
public class Utils {
	
	public static final int SECOND_IN_MILISSECONDS = 1000;
	public static final int MINUTE_IN_MILISSECONDS = 60 * SECOND_IN_MILISSECONDS;

	public static boolean eqFloat(float f1, float f2) {
		int int1 = (int) Math.round(f1);
		int int2 = (int) Math.round(f2);
		return int1 == int2;
	}



	public static int clamp(int n, int min, int max) {

		if (min > max)
			return clamp(n, max, min);

		if (n < min)
			n = min;

		if (n > max)
			n = max;

		return n;
	}

	public static float clamp(float n, float min, float max) {

		if (min > max)
			return clamp(n, max, min);

		if (n < min)
			n = min;

		if (n > max)
			n = max;

		return n;
	}
}
