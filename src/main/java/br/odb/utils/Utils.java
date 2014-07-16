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

	// public static String readLine( InputStream reader) throws IOException {
	// StringBuffer line = new StringBuffer();
	// int c = reader.read();
	//
	// while (c != -1 && c != '\n') {
	// line.append((char)c);
	// c = reader.read();
	// }
	//
	// if (line.length() == 0) {
	// return null;
	// }
	//
	// return line.toString();
	// }

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

	public static Vec2 getTranslationForOctant(int octant) {
		return translations[clamp(octant)];
	}

	private static Vec2[] translations;

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

	public static final float transformTableIncrements = 30.0f;
	public static final int SECOND_IN_MILISSECONDS = 1000;
	public static final int MINUTE_IN_MILISSECONDS = 60 * SECOND_IN_MILISSECONDS;

	static {
		translations = new Vec2[17];

		translations[0] = new Vec2((float) Math.sin(0.000f * Math.PI) / 4.0f,
				(float) Math.cos(0.000f * Math.PI) / 4.0f); // 0
		translations[1] = new Vec2((float) Math.sin(0.166f * Math.PI) / 4.0f,
				(float) Math.cos(0.166f * Math.PI) / 4.0f);
		translations[2] = new Vec2((float) Math.sin(0.333f * Math.PI) / 4.0f,
				(float) Math.cos(0.333f * Math.PI) / 4.0f);
		translations[3] = new Vec2((float) Math.sin(0.500f * Math.PI) / 4.0f,
				(float) Math.cos(0.500f * Math.PI) / 4.0f);
		translations[4] = new Vec2((float) Math.sin(0.666f * Math.PI) / 4.0f,
				(float) Math.cos(0.666f * Math.PI) / 4.0f);
		translations[5] = new Vec2((float) Math.sin(0.833f * Math.PI) / 4.0f,
				(float) Math.cos(0.833f * Math.PI) / 4.0f);

		translations[6] = new Vec2((float) Math.sin(1.000f * Math.PI) / 4.0f,
				(float) Math.cos(1.000f * Math.PI) / 4.0f);
		translations[7] = new Vec2((float) Math.sin(1.166f * Math.PI) / 4.0f,
				(float) Math.cos(1.166f * Math.PI) / 4.0f);
		translations[8] = new Vec2((float) Math.sin(1.333f * Math.PI) / 4.0f,
				(float) Math.cos(1.333f * Math.PI) / 4.0f); // 180
		translations[9] = new Vec2((float) Math.sin(1.500f * Math.PI) / 4.0f,
				(float) Math.cos(1.500f * Math.PI) / 4.0f);
		translations[10] = new Vec2((float) Math.sin(1.666f * Math.PI) / 4.0f,
				(float) Math.cos(1.666f * Math.PI) / 4.0f);
		translations[11] = new Vec2((float) Math.sin(1.833f * Math.PI) / 4.0f,
				(float) Math.cos(1.833f * Math.PI) / 4.0f);
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

	public static int getOppositeDirection(int d) {

		switch (d) {

		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 5;
		case 5:
			return 4;
		}

		return 0;
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
