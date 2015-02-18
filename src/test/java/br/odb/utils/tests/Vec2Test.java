/**
 * 
 */
package br.odb.utils.tests;

import junit.framework.Assert;

import org.junit.Test;

import br.odb.utils.math.Vec2;

/**
 * @author monty
 *
 */
public class Vec2Test {

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( v1.hashCode(), v2.hashCode() );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#Vec2()}.
	 */
	@Test
	public void testVec2() {
		Vec2 v1 = new Vec2();
		
		Assert.assertEquals( 0.0f, v1.x, 0.001f );
		Assert.assertEquals( 0.0f, v1.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#Vec2(float, float)}.
	 */
	@Test
	public void testVec2FloatFloat() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( 1.0f, v1.x, 0.001f );
		Assert.assertEquals( 2.0f, v1.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#Vec2(br.odb.utils.math.Vec2)}.
	 */
	@Test
	public void testVec2Vec2() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = new Vec2( v1 );
		
		Assert.assertEquals( v1, v2 );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#add(br.odb.utils.math.Vec2)}.
	 */
	@Test
	public void testAdd() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = v1.add( new Vec2( 2.0f, 3.0f ) );
		Assert.assertEquals( 3.0f, v2.x, 0.001f );
		Assert.assertEquals( 5.0f, v2.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#toString()}.
	 */
	@Test
	public void testToString() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( "vec2( 1.0, 2.0 )", v1.toString().toLowerCase() );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#sub(br.odb.utils.math.Vec2)}.
	 */
	@Test
	public void testSub() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = v1.sub( new Vec2( 1.0f, 1.0f ) );
		Assert.assertEquals( 0.0f, v2.x, 0.001f );
		Assert.assertEquals( 1.0f, v2.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( v1, v2 );
		
		v2.x = 0.0f;
		Assert.assertFalse( v1.equals( v2 ) );
		v2.x = 1.0f;
		v2.y = 3.0f;
		Assert.assertFalse( v1.equals( v2 ) );
		v2.x = 0.0f;
		Assert.assertFalse( v1.equals( v2 ) );
		
		Assert.assertTrue( v1.equals( v1 ) );		
		Assert.assertFalse( v1.equals( null ) );
		Assert.assertFalse( v1.equals( "not even a Vec2!" ) );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#invalidate()}.
	 */
	@Test
	public void testInvalidate() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		v1.invalidate();
		
		Assert.assertEquals( Float.NaN, v1.x, 0.001f );
		Assert.assertEquals( Float.NaN, v1.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#length()}.
	 */
	@Test
	public void testLength() {
		Vec2 v1 = new Vec2();		
		
		v1.set( 1.0f, 0.0f );
		Assert.assertEquals( 1.0f, v1.length(), 0.001f );
		v1.set( 0.0f, 1.0f );
		Assert.assertEquals( 1.0f, v1.length(), 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#normalize()}.
	 */
	@Test
	public void testNormalize() {
		Vec2 v1 = new Vec2();		
		
		v1.set( 1.0f, 3.0f );
		v1.normalize();
		
		Assert.assertEquals( 1.0f, v1.length(), 0.001f );

	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#normalized()}.
	 */
	@Test
	public void testNormalized() {
		Vec2 v1 = new Vec2();		
		
		v1.set( 1.0f, 3.0f );
		
		Assert.assertEquals( 1.0f, v1.normalized().length(), 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#isValid()}.
	 */
	@Test
	public void testIsValid() {
		Vec2 v1 = new Vec2();		
		
		v1.set( 1.0f, 3.0f );
		
		Assert.assertTrue( v1.isValid() );
		v1.set( Float.NaN, 1.0f );
		Assert.assertFalse( v1.isValid() );
		v1.set( 1.0f, Float.NaN );
		Assert.assertFalse( v1.isValid() );
		
		v1.set( Float.NEGATIVE_INFINITY, 1.0f );
		Assert.assertFalse( v1.isValid() );
		v1.set( 1.0f, Float.NEGATIVE_INFINITY );
		Assert.assertFalse( v1.isValid() );
		
		v1.set( Float.POSITIVE_INFINITY, 1.0f );
		Assert.assertFalse( v1.isValid() );
		v1.set( 1.0f, Float.POSITIVE_INFINITY );
		Assert.assertFalse( v1.isValid() );
		
		v1.set( 1.0f, 3.0f );
		
		v1.invalidate();
		Assert.assertFalse( v1.isValid() );
		
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#set(br.odb.utils.math.Vec2)}.
	 */
	@Test
	public void testSetVec2() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		Vec2 v2 = new Vec2();
		
		v2.set( v1 );
		Assert.assertEquals( 1.0f, v2.x, 0.001f );
		Assert.assertEquals( 2.0f, v2.y, 0.001f );

		v2.set( v2 );
		Assert.assertEquals( 1.0f, v2.x, 0.001f );
		Assert.assertEquals( 2.0f, v2.y, 0.001f );

		v1.invalidate();
		
		v2.set( v1 );
		Assert.assertEquals( 1.0f, v2.x, 0.001f );
		Assert.assertEquals( 2.0f, v2.y, 0.001f );
		
		v2.set( null );
		Assert.assertEquals( 1.0f, v2.x, 0.001f );
		Assert.assertEquals( 2.0f, v2.y, 0.001f );
		
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#scale(float)}.
	 */
	@Test
	public void testScale() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( 1.0f, v1.x, 0.001f );
		Assert.assertEquals( 2.0f, v1.y, 0.001f );
		
		v1.scale( 2.0f );

		Assert.assertEquals( 2.0f, v1.x, 0.001f );
		Assert.assertEquals( 4.0f, v1.y, 0.001f );
		
		v1.scale( 0.25f );
		
		Assert.assertEquals( 0.5f, v1.x, 0.001f );
		Assert.assertEquals( 1.0f, v1.y, 0.001f );
		
		v1.scale( 0.0f );
		
		Assert.assertEquals( 0.0f, v1.x, 0.001f );
		Assert.assertEquals( 0.0f, v1.y, 0.001f );		
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#scaled(float)}.
	 */
	@Test
	public void testScaledFloat() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( 1.0f, v1.x, 0.001f );
		Assert.assertEquals( 2.0f, v1.y, 0.001f );
		
		Vec2 v2 = v1.scaled( 2.0f );

		Assert.assertEquals( 2.0f, v2.x, 0.001f );
		Assert.assertEquals( 4.0f, v2.y, 0.001f );
		
		Vec2 v3 = v1.scaled( 0.5f );
		
		Assert.assertEquals( 0.5f, v3.x, 0.001f );
		Assert.assertEquals( 1.0f, v3.y, 0.001f );
		
		Vec2 v4 = v1.scaled( 0.0f );
		
		Assert.assertEquals( 0.0f, v4.x, 0.001f );
		Assert.assertEquals( 0.0f, v4.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#addTo(br.odb.utils.math.Vec2)}.
	 */
	@Test
	public void testAddTo() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );
		
		Assert.assertEquals( 1.0f, v1.x, 0.001f );
		Assert.assertEquals( 2.0f, v1.y, 0.001f );
		
		v1.addTo( v1 );

		Assert.assertEquals( 2.0f, v1.x, 0.001f );
		Assert.assertEquals( 4.0f, v1.y, 0.001f );
		
		Vec2 v2 = new Vec2();
		v2.invalidate();
		
		v1.addTo( v2 );
		
		Assert.assertEquals( 2.0f, v1.x, 0.001f );
		Assert.assertEquals( 4.0f, v1.y, 0.001f );

		v1.addTo( null );

		Assert.assertEquals( 2.0f, v1.x, 0.001f );
		Assert.assertEquals( 4.0f, v1.y, 0.001f );
		
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#negated()}.
	 */
	@Test
	public void testNegated() {
		Vec2 v1 = new Vec2( 1.0f, 0.0f );
		v1 = v1.negated();
		Assert.assertEquals( -1.0f, v1.x, 0.001f );
		Assert.assertEquals( 0.0f, v1.y, 0.001f );
	}

	/**
	 * Test method for {@link br.odb.utils.math.Vec2#scaled(float, float)}.
	 */
	@Test
	public void testScaledFloatFloat() {
		Vec2 v1 = new Vec2( 1.0f, 2.0f );

		v1 = v1.scaled( 2.0f, 3.0f );
		Assert.assertEquals( 2.0f, v1.x, 0.001f );
		Assert.assertEquals( 6.0f, v1.y, 0.001f );
		
		v1 = v1.scaled( Float.NaN, 0.0f );
		Assert.assertEquals( Float.NaN, v1.x, 0.001f );
		Assert.assertEquals( 0.0f, v1.y, 0.001f );
		
		v1 = v1.scaled( 2.0f, 3.0f );
		Assert.assertEquals( Float.NaN, v1.x, 0.001f );
		Assert.assertEquals( 0.0f, v1.y, 0.001f );
	}
}
