/**
 * 
 */
package br.odb.utils.math;

import br.odb.utils.Utils;

/**
 * @author monty
 * 
 */
public class Matrix {
	
	public float[][] values;
	int sizeX;
	int sizeY;

	public Matrix(int dx, int dy, float[] rawData) {
		init(dx, dy, rawData);
	}

	public Matrix(Matrix matrix) {
		init(matrix);
	}

	public Matrix(int i, int j) {
		init(i, j, null);
	}

	private void init(int dx, int dy, float[] rawData) {

		int head = 0;
		sizeX = dx;
		sizeY = dy;
		values = new float[dy][];

		for (int c = 0; c < dy; ++c) {

			values[c] = new float[dx];

			for (int d = 0; d < dx; ++d) {

				if (rawData != null && head < rawData.length) {
					values[c][d] = rawData[head];
					++head;
				} else {
					values[c][d] = 0.0f;
				}
			}
		}
	}

	private float[] getRawDataCopy() {
		float[] toReturn = new float[ sizeX * sizeY ];

		int used = 0;

		for (int c = 0; c < sizeY; ++c) {
			for (int d = 0; d < sizeX; ++d) {
				toReturn[used] = values[c][d];
				++used;
			}
		}

		return toReturn;
	}

	private void init(Matrix m) {
		init( m.sizeX, m.sizeY, m.getRawDataCopy());
	}

	public static Matrix makeIdentity(int i) {

		float[] rawData = new float[i * i];

		for (int x = 0; x < i; ++x) {
			for (int y = 0; y < i; ++y) {
				rawData[(i * y) + x] = (x == y) ? 1.0f : 0.0f;
			}
		}

		Matrix m = new Matrix(i, i, rawData);
		return m;
	}

	public static Matrix makeRotationAlongZ(double rads) {

		float sin = (float) Math.sin(Math.PI / 2.0f);
		float cos = (float) Math.cos(Math.PI / 2.0f);
		float[] rawData = new float[9];
		rawData[0] = cos;
		rawData[1] = -sin;
		rawData[2] = 0.0f;
		rawData[3] = sin;
		rawData[4] = cos;
		rawData[5] = 0.0f;
		rawData[6] = 0.0f;
		rawData[7] = 0.0f;
		rawData[8] = 1.0f;

		Matrix m = new Matrix(3, 3, rawData);

		return m;
	}

	public boolean isIdentity() {

		for (int x = 0; x < sizeX; ++x) {
			for (int y = 0; y < sizeY; ++y) {

				if (x == y) {
					if ( Math.abs( values[ y ][ x ] - 1.0f ) > 0.1f ) {						
						return false;
					}
				} else {
					if (!Utils.eqFloat(0.0f, values[y][x]))
						return false;
				}
			}
		}

		return true;
	}

	public boolean isNullMatrix() {

		for (int x = 0; x < sizeX; ++x) {

			for (int y = 0; y < sizeY; ++y) {

				if (!Utils.eqFloat(0.0f, values[y][x]))
					return false;
			}
		}

		return true;
	}

	public float get( int x, int y ) {
		return values[ y ][ x ];
	}
	
	public void set(int x, int y, float f) {
		values[ y ][ x ] = f;		
	}
}
