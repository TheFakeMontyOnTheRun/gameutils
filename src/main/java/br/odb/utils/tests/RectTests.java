package br.odb.utils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.Rect;
import br.odb.utils.Utils;
import br.odb.utils.math.Vec2;

public class RectTests {
	
	@Test
	public final void testEquals() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		
		
		String anotherKind = "another kind of object";
		
		Assert.assertTrue( rect1.equals( rect1 ) );
		Assert.assertFalse( rect1.equals( anotherKind ) );
		Assert.assertFalse( rect1.equals( null ) );
	}
	
	@Test
	public final void testCopyRect() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Rect rect2 = new Rect( rect1 );
		
		Assert.assertEquals( rect1, rect2 );
	}
	
	@Test 
	public final void testDifferentials() {
		Rect rect1 = new Rect( 3.0f, 4.0f, 1.0f, 2.0f );
		
		Assert.assertEquals( rect1.getDX(), 1.0f, 0.1f );
		Assert.assertEquals( rect1.getDY(), 2.0f, 0.1f );
		
		
		rect1.setD( 5, 6 );
		
		Assert.assertEquals( rect1.p0.x, 3.0f, 0.1f );
		Assert.assertEquals( rect1.p0.y, 4.0f, 0.1f );
		
		Assert.assertEquals( rect1.getDX(), 5.0f, 0.1f );
		Assert.assertEquals( rect1.getDY(), 6.0f, 0.1f );

	}
	
	@Test
	public final void testIsInitialized() {
		Rect rect = new Rect();
		
		Assert.assertTrue( Utils.eqFloat( rect.p0.x, 0.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.x, 0.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p0.y, 0.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.y, 0.0f ) );

		rect.set( 2, 3, 4, 5 );
		Assert.assertTrue( Utils.eqFloat( rect.p0.x, 2.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.x, 6.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p0.y, 3.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.y, 8.0f ) );
		
		rect.setD( 10, 10 );
		Assert.assertTrue( Utils.eqFloat( rect.p0.x, 2.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.x, 12.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p0.y, 3.0f ) );
		Assert.assertTrue( Utils.eqFloat( rect.p1.y, 13.0f ) );

		
	}

	@Test
	public final void testIdentificalRectsIntersection() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Rect rect2 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );

		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		
		Assert.assertTrue( rect2.intersect( rect2 ) );
		
		Assert.assertFalse( rect2.intersect( null ) );
	}
	
	@Test
	public final void testIntersectCorners() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Rect rect2 = new Rect( 1.0f, 1.0f, 2.0f, 2.0f );

		Assert.assertTrue( rect1.intersect( rect2 ) );
		
		rect2.set( 2.0f, 2.0f, 2.0f, 2.0f );
		
		Assert.assertTrue( rect1.intersect( rect2 ) );
	}
	
	@Test
	public final void testPointsInside() {
		
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Vec2 point = new Vec2();
		
		point.set( 0.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) ); 
		point.set( 0.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 1.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 1.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 1.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 0.0f, 1.0f );		
		Assert.assertTrue( rect1.isInside(point) );

		rect1.set( 0.5f, 0.5f, 1.0f, 1.0f );
		
		point.set( 0.0f, 0.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 2.0f, 0.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 0.0f, 2.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 2.0f, 2.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 1.0f, 0.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 2.0f, 1.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 1.0f, 2.0f );		
		Assert.assertFalse( rect1.isInside(point) );
		point.set( 0.0f, 1.0f );		
		Assert.assertFalse( rect1.isInside(point) );


		rect1.set( -10.0f, -10.f, 20.0f, 20.0f );

		point.set( 0.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 0.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 1.0f, 0.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 2.0f, 1.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 1.0f, 2.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		point.set( 0.0f, 1.0f );		
		Assert.assertTrue( rect1.isInside(point) );
		
	}
	
	@Test
	public final void testDisjointRectsIntersection() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Rect rect2 = new Rect( 3.0f, 0.0f, 2.0f, 2.0f );

		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );
	}
}
