package br.odb.utils.tests;



import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.Rect;
import br.odb.utils.Utils;
import br.odb.utils.math.Vec2;

public class RectTest {
	
	@Test
	public final void testEquals() {
		Rect rect1 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		Rect rect2 = new Rect( 0.0f, 0.0f, 2.0f, 2.0f );
		
		String anotherKind = "another kind of object";
		
		Assert.assertTrue( rect1.equals( rect1 ) );
		Assert.assertTrue( rect1.equals( rect2 ) );
		Assert.assertEquals( rect1.hashCode(), rect2.hashCode() );
		Assert.assertFalse( rect1.equals( anotherKind ) );
		Assert.assertFalse( rect1.equals( null ) );
		
		rect2.p0.set( rect1.p0 );
		rect2.p1.set( rect1.p1 );
		rect2.p0.set( 0.5f, 0.5f );
		Assert.assertFalse( rect1.equals( rect2 ) );
		Assert.assertNotSame( rect1.hashCode(), rect2.hashCode() );
		rect2.p0.set( rect1.p0 );
		rect2.p1.set( rect1.p1 );
		rect2.p1.set( 0.5f, 0.5f );
		Assert.assertFalse( rect1.equals( rect2 ) );
		Assert.assertNotSame( rect1.hashCode(), rect2.hashCode() );
		
		rect2.p0.set( rect1.p0 );
		rect2.p1.set( rect1.p1 );
		rect2.p1.set( 0.5f, 0.5f );
		rect2.p1.set( 2.5f, 2.5f );
		Assert.assertFalse( rect1.equals( rect2 ) );
		Assert.assertNotSame( rect1.hashCode(), rect2.hashCode() );
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

		//   ___
		//  | 1_|_
		//  |_| 2 |
		//    |___|
		//
		rect2.set( 1.0f, 1.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		//    ___
		//   | 1 |
		//   |___|___
		//    	 | 2 |
		//  	 |___|
		//	
		rect2.set( 2.0f, 2.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		
		//  	  ___
		//     __| 1 |
		//    | 2 |__|
		//    |___|
		//
		rect2.set( -1.0f, 1.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		//  	  ___
		//       | 1 |
		//     __| __|		
		//    | 2 |
		//    |___|
		//
		rect2.set( -2.0f, 2.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );

		//       ____________
		//     	 |	  ___	|
		//    	 |2  | 1 |  |
		//   	 |   |___|  |
		//  	 |__________|
		//	
		rect2.set( -5.0f, -5.0f, 10.0f, 10.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		

		//            ___
		//       ____|   |___
		//     	 |	 |   |  |
		//    	 |1  | 2 |  |
		//   	 |   |   |  |
		//  	 |___|   |__|
		//           |___|	
		rect2.set( 1.0f, -1.0f, 0.5f, 10.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		
		
		//   ___
		//  | 2_|_
		//  |_| 1 |
		//    |___|
		//
		rect2.set( -1.0f, -1.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		//    ___
		//   | 2 |
		//   |___|___
		//    	 | 1 |
		//  	 |___|
		//	
		rect2.set( -2.0f, -2.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		
		//  	  ___
		//     __| 2 |
		//    | 1 |__|
		//    |___|
		//
		rect2.set( 1.0f, -1.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		//  	  ___
		//       | 2 |
		//     __| __|		
		//    | 1 |
		//    |___|
		//
		rect2.set( 2.0f, -2.0f, 2.0f, 2.0f );		
		Assert.assertTrue( rect1.intersect( rect2 ) );
		Assert.assertTrue( rect2.intersect( rect1 ) );
		
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
		
		rect2.set( 0.0f, -3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );
		
		rect2.set( 3.0f, -3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( 3.0f, 0.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( 3.0f, 3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( 0.0f, -3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( -3.0f, 3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( -3.0f, 0.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		rect2.set( -3.0f, -3.0f, 2.0f, 2.0f );
		Assert.assertFalse( rect1.intersect( rect2 ) );
		Assert.assertFalse( rect2.intersect( rect1 ) );

		
		
	}
}
