/**
 * 
 */
package br.odb.utils;

/**
 * Utility methods that don't belong anywhere else.
 * @author Daniel "Monty" Monteiro 
 */
public class Utils {
	
	public static final int SECOND_IN_MILISSECONDS = 1000;
	public static final int MINUTE_IN_MILISSECONDS = 60 * SECOND_IN_MILISSECONDS;

	
	/**
	 * There is no point in creating a object from this.
	 */
	public Utils() {
		
	}
	
	/**
	 * @return true if the distance between the two numbers is less then 0.1, false otherwise
	 */
	public static boolean eqFloat(float f1, float f2) {
		
		if ( Float.isNaN( f1 ) ) {
			return Float.isNaN( f2 );
		}
		
		return Math.abs( f1 - f2 ) < 0.1f;
	}

	/**
	 * Restrains a number in a interval
	 * @param n the original number
	 * @param min the minimum value of the interval
	 * @param max the maximum value of the interval
	 * @return a valid number inside the said interval. If min > max, then the interval will be reversed
	 */
	public static int clamp(int n, int min, int max) {

		if (min > max)
			return clamp(n, max, min);

		if (n < min)
			n = min;

		if (n > max)
			n = max;

		return n;
	}

	/**
	 * Restrains a number in a interval
	 * @param n the original number
	 * @param min the minimum value of the interval
	 * @param max the maximum value of the interval
	 * @return a valid number inside the said interval. If min > max, then the interval will be reversed
	 */
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
