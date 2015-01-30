/**
 * 
 */
package br.odb.utils.tests;

import junit.framework.Assert;

import org.junit.Test;

import br.odb.utils.math.Vec3;

/**
 * @author monty
 *
 */
public class Vec3Test {

	@Test
	public void testDefaultConstructor() {
		Vec3 v = new Vec3();
		Assert.assertEquals( v.x, 0.0f, 0.1f );
		Assert.assertEquals( v.y, 0.0f, 0.1f );
		Assert.assertEquals( v.z, 0.0f, 0.1f );
		
		Assert.assertTrue( v.isValid() );
	}
	
	@Test
	public void isValid() {
		Vec3 v;
		v= new Vec3( Float.POSITIVE_INFINITY, 0.0f, 0.0f );
		Assert.assertFalse( v.isValid() );
		
		v= new Vec3( 0.0f, Float.POSITIVE_INFINITY, 0.0f );
		Assert.assertFalse( v.isValid() );

		
		v= new Vec3( 0.0f, 0.0f, Float.POSITIVE_INFINITY );
		Assert.assertFalse( v.isValid() );

		v= new Vec3( Float.NaN, 0.0f, 0.0f );
		Assert.assertFalse( v.isValid() );
		
		v= new Vec3( 0.0f, Float.NaN, 0.0f );
		Assert.assertFalse( v.isValid() );

		
		v= new Vec3( 0.0f, 0.0f, Float.NaN );
		Assert.assertFalse( v.isValid() );
	}
	
	@Test
	public void testAdd() {
		Vec3 v1 = new Vec3( 1.0f, 2.0f, 3.0f );
		Vec3 v2 = new Vec3( 4.0f, 5.0f, 6.0f );
		
		Vec3 v3 = v1.add( v2 );
		Assert.assertEquals( new Vec3( 5.0f, 7.0f, 9.0f ), v3 );
		
		v1.addTo(v2);
		
		Assert.assertEquals( v1, v3 );
		
		v1.addTo( -v1.x, -v1.y, -v1.z );
		Assert.assertEquals( new Vec3( 0.0f, 0.0f, 0.0f ), v1 );
	}
	
	@Test
	public void testSub() {
		Vec3 v1 = new Vec3( 1.0f, 2.0f, 3.0f );
		Vec3 v2 = new Vec3( 4.0f, 5.0f, 6.0f );
		
		Vec3 v3 = v2.sub( v1 );
		Assert.assertEquals( new Vec3( 3.0f, 3.0f, 3.0f ), v3 );
	}
	
	@Test
	public void testNormalize() {
		Vec3 v1 = new Vec3( 1.0f, 2.0f, 3.0f );
		Vec3 v2 = new Vec3( 0.0f, 0.0f, 0.0f );
		Vec3 v3 = v1.normalized();
		v1.normalize();
		v2.normalize();
		Assert.assertEquals( v1, v3 );
		Assert.assertTrue( v1.isValid() );
		Assert.assertFalse( v2.isValid() );
		Assert.assertEquals( 1, Math.round( v1.length() ) );
		Assert.assertEquals( Float.NaN, v2.length() );
	}
	
	@Test
	public void testCopyConstructor() {
		Vec3 v = new Vec3();
		v.set( 1.0f, 2.0f, 3.0f );
		Vec3 v2 = new Vec3( v );
		
		Assert.assertEquals( v.x, 1.0f, 0.1f );
		Assert.assertEquals( v.y, 2.0f, 0.1f );
		Assert.assertEquals( v.z, 3.0f, 0.1f );
		Assert.assertTrue( v.isValid() );
		Assert.assertEquals( v, v2 );
		Assert.assertEquals( v2, v );
		Assert.assertEquals( v, v );
		Assert.assertEquals( v.hashCode(), v.hashCode() );
		Assert.assertEquals( v.toString(), v.toString() );
		Assert.assertNotSame( v, null );

		v.set( Float.NaN, Float.NaN, Float.NaN );
		Assert.assertNotSame( v, v2 );
		Assert.assertNotSame( v2, v );
		v2 = new Vec3( v );
		
		Assert.assertTrue( Float.isNaN( v2.x ) );
		Assert.assertTrue( Float.isNaN( v2.y ) );
		Assert.assertTrue( Float.isNaN( v2.z ) );
		Assert.assertFalse( v2.isValid() );
	}
	
	@Test
	public void testEquals() {
		Vec3 v = new Vec3();
		Vec3 v2 = new Vec3( 2, 2, 2 );
		Vec3 v3 = new Vec3( 2, 2, 2 );
		
		Vec3 v4 = new Vec3( 2, 2, 1 );
		Vec3 v5 = new Vec3( 2, 1, 1 );
		Vec3 v6 = new Vec3( 1, 1, 1 );
		
		String nonV = "not a vector";
		
		Assert.assertFalse( v.equals( v2 ) );
		Assert.assertFalse( v2.equals( v ) );
		
		Assert.assertFalse( v.equals( nonV ) );
		Assert.assertFalse( nonV.equals( v ) );
		
		Assert.assertFalse( v.equals( null ) );
		
		Assert.assertTrue( v2.equals( v2 ) );
		
		Assert.assertTrue( v3.equals( v2 ) );
		Assert.assertTrue( v2.equals( v3 ) );
		
		Assert.assertFalse( v2.equals( v4 ) );
		Assert.assertFalse( v2.equals( v5 ) );
		Assert.assertFalse( v2.equals( v6 ) );
		
		v6.set( v2 );
		
		Assert.assertTrue( v2.equals( v6 ) );
	}
	
	
	@Test
	public void testLength() {
		Vec3 v = new Vec3();
		
		v.set( 0, 0 ,0 );
		Assert.assertEquals( 0.0f, v.length(), 0.1f );
		
		v.set( 1, 1 ,1 );
		Assert.assertEquals( Math.sqrt( 3.0f ), v.length(), 0.1f );

		v.set( 2, 0 , 2 );
		Assert.assertEquals( 2.0f * Math.sqrt( 2.0f ), v.length(), 0.1f );
		
		v.set( 2, 2 , 2 );
		Assert.assertEquals( 2.0f * Math.sqrt( 3.0f ), v.length(), 0.1f );
		
		v.set( 2, 2 , 2 );
		v.normalize();
		Assert.assertEquals( 1.0f, v.length(), 0.1f );
		
	}
}
