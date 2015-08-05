package br.odb.utils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.math.Matrix;

public class MatrixTest {

	@Test
	public void testMatrixIntIntFloatArray() {
		Matrix m = new Matrix( 2, 2, new float[] { 1.0f, 0.0f, 0.0f, 1.0f } );
		Assert.assertTrue( m.isIdentity() );
	}

	@Test
	public void testMatrixMatrix() {
		Matrix m = Matrix.makeIdentity( 3 );
		Matrix m2 = new Matrix( m );
		Assert.assertTrue( m2.isIdentity() );
	}

	@Test
	public void testMatrixIntInt() {
		Matrix m = new Matrix( 2, 2 );
		for ( int x = 0; x < 2; ++x ) {
			for ( int y = 0; y < 2; ++y ) {
				Assert.assertEquals( 0.0f, m.values[  ( y * m.sizeX ) + x  ], 0.001f );
			}
		}
	}

	@Test
	public void testMakeIdentity() {
		Matrix m = Matrix.makeIdentity( 3 );
		
		for ( int x = 0; x < 3; ++x ) {
			for ( int y = 0; y < 3; ++y ) {
				Assert.assertEquals( ( x == y) ? 1.0f : 0.0f, m.values[  ( y * m.sizeX ) + x  ], 0.001f );
			}
		}
	}

	@Test
	public void testMakeRotationAlongZ() {
		float angle = (float) (Math.PI / 2.0f);
		Matrix m = Matrix.makeRotationAlongZ( angle );
		float cos = (float) Math.cos( angle );
		float sin = (float) Math.sin( angle );
		
		Assert.assertEquals( cos, m.get( 0, 0 ), 0.001f );
		Assert.assertEquals( -sin, m.get( 1, 0 ), 0.001f );
		Assert.assertEquals( 0.0f, m.get( 2, 0 ), 0.001f );
		
		Assert.assertEquals( sin, m.get( 0, 1 ), 0.001f );
		Assert.assertEquals( cos, m.get( 1, 1 ), 0.001f );
		Assert.assertEquals( 0.0f, m.get( 2, 1 ), 0.001f );
		
		Assert.assertEquals( 0.0f, m.get( 0, 2 ), 0.001f );
		Assert.assertEquals( 0.0f, m.get( 1, 2 ), 0.001f );
		Assert.assertEquals( 1.0f, m.get( 2, 2 ), 0.001f );
	}

	@Test
	public void testIsIdentity() {
		Matrix m = new Matrix( 3, 3 );
		
		for ( int x = 0; x < 3; ++x ) {
			for ( int y = 0; y < 3; ++y ) {
				m.set( x, y, ( x == y) ? 1.0f : 0.0f );
			}
		}

		Assert.assertTrue( m.isIdentity() );
		
		m.set( 1, 0, 5.0f );
		
		Assert.assertFalse( m.isIdentity() );
		
		m.setAsIdentity();
		
		Assert.assertTrue( m.isIdentity() );
		
		m.set( 1, 1, 5.0f );
		
		Assert.assertFalse( m.isIdentity() );		
	}

	@Test
	public void testIsNullMatrix() {
		Matrix m = new Matrix( 3, 3 );
		Assert.assertTrue( m.isNullMatrix() );
		m.set( 1, 0, 5.0f );
		Assert.assertFalse( m.isNullMatrix() );		
	}
}
