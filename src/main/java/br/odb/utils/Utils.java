/**
 * 
 */
package br.odb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import br.odb.utils.math.Vec2;



/**
 * @author monty
 * 
 */
public class Utils {

	/**
	 * @author monty
	 * 
	 */

	private static int clamp(int angle) {
		int quadrant = angle;

		while (quadrant < 0) {
			quadrant += 12;
		}

		quadrant = (quadrant) % 12;
		return quadrant;
	}
	
	public static <T> Object[] reverseArray( T[] originalArray ) {
		ArrayList< T > tmp = new ArrayList< T >();
		
		
		for ( T i : originalArray ) {
			tmp.add( 0, i );
		}
		
		return tmp.toArray();

	}
	

	// http://stackoverflow.com/questions/17379020/how-to-find-the-largest-power-of-2-less-than-the-given-number
	public static int nextPowerOfTwo(int n) {
		int res = 2;
		while (res < n) {
			res *= 2;
		}

		return res;
	}


	public static boolean eqFloat(float f1, float f2) {
		int int1 = (int) (f1 * 1000);
		int int2 = (int) (f2 * 1000);
		return int1 == int2;
	}

	public static boolean eqFloat(float f1, float f2, int point) {
		int int1 = (int) (f1 * point);
		int int2 = (int) (f2 * point);
		return int1 == int2;
	}

	public static final String getSubToken(String main, int token) {
		return getSubTokenAtRange(main, token, main.length());
	}

	public static final String getSubTokenAtRange(String main, int token,
			int end) {

		int index = 0;
		int tokens = 0;

		for (int c = 0; c < main.length(); ++c) {
			if (main.charAt(c) == ' ') {

				++tokens;

				if (tokens - 1 == token) {
					return main.substring(index, c);
				} else {
					index = c + 1;
				}
			}
		}
		return main.substring(index);
	}

	public static final int SECOND_IN_MILISSECONDS = 1000;
	public static final int MINUTE_IN_MILISSECONDS = 60 * SECOND_IN_MILISSECONDS;

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

	public static float snap(float value) {

		return (int) value;
	}

	public static int pow2For(int x) {

		--x;
		x |= x >> 1;
		x |= x >> 2;
		x |= x >> 4;
		x |= x >> 8;
		x |= x >> 16;
		return ++x;
	}

	public static boolean eqFloatTrunc10(float f1, float f2) {

		int i1 = (Math.round(f1 / 10.0f));
		int i2 = (Math.round(f2 / 10.0f));

		return i1 == i2;
	}

	public static String extractPathFrom(String filePath) {
		return filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
	}

	public static String extractFilenameFrom(String filePath) {
		return filePath.substring(filePath.lastIndexOf(File.separator) + 1);
	}

	public static String[] tokenize(String entry, String separator) {

		String[] toReturn;
		ArrayList<String> listBuilder = new ArrayList<String>();

		StringTokenizer stt = new StringTokenizer(entry, separator);

		while (stt.hasMoreTokens()) {
			String token = stt.nextToken();
			listBuilder.add(token);
		}

		toReturn = new String[listBuilder.size()];
		toReturn = listBuilder.toArray(toReturn);
		return toReturn;
	}
}
