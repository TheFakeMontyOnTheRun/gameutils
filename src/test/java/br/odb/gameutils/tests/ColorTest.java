package br.odb.gameutils.tests;

import br.odb.gameutils.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

	@Test
	public void testMultiply() {
		Color colour = new Color( 64, 32, 16, 8 );
		
		colour.multiply( 2.0f );
		Assert.assertEquals( new Color( 128, 64, 32, 16 ), colour );
		
		colour.multiply( 0.25f );
		Assert.assertEquals( new Color( 32, 16, 8, 4 ), colour );		

		colour.multiply( 0.0f );
		Assert.assertEquals( new Color( 0.0f, 0.0f, 0.0f, 0.0f ), colour );		

	}
	
	@Test
	public void testFloatData() {
		
		Color colour = new Color( 64, 32, 16, 8 );
		float[] data = colour.getFloatData();
		
		Assert.assertEquals( 64 / 255.0f, data[ 0 ], 0.001f );
		Assert.assertEquals( 32 / 255.0f, data[ 1 ], 0.001f );
		Assert.assertEquals( 16 / 255.0f, data[ 2 ], 0.001f );
		Assert.assertEquals(  8 / 255.0f, data[ 3 ], 0.001f );
	}
	
	
	@Test
	public void testGetARGB() {
		Color colour;
		colour = new Color( 0xFF00FF00 );
		
		Assert.assertEquals( 0xFF00FF00, colour.getARGBColor() );
	}
	
	@Test
	public void testSet() {
		Color c1 = new Color();
		Color c2 = new Color();
		
		c1.set( 255, 128, 64 );
		
		Assert.assertEquals( 255, c1.r );
		Assert.assertEquals( 128, c1.g );
		Assert.assertEquals( 64, c1.b );
		Assert.assertEquals( 255, c1.a );
		
		c2.set( c1 );

		Assert.assertEquals( 255, c2.r );
		Assert.assertEquals( 128, c2.g );
		Assert.assertEquals( 64, c2.b );
		Assert.assertEquals( 255, c2.a );
		
		c2.set( null );
		Assert.assertEquals( 255, c2.r );
		Assert.assertEquals( 128, c2.g );
		Assert.assertEquals( 64, c2.b );
		Assert.assertEquals( 255, c2.a );
	}
	
	
	@Test
	public void testEqualsAndHashcode() {
		Color c1;
		Color c2;
		
		c1 = new Color( 255, 128, 64 );
		c2 = new Color( 255, 128, 64 );
		
		Assert.assertEquals( c1.hashCode(), c2.hashCode() );
		Assert.assertEquals( c1, c2 );
		Assert.assertEquals( c1.r, c2.r );
		Assert.assertEquals( c1.g, c2.g );
		Assert.assertEquals( c1.b, c2.b );
		Assert.assertEquals( c1.a, c2.a );
		
		c2.set( c1 );
		c2.r = 0;		
		Assert.assertFalse( c1.equals( c2 ) );

		c2.set( c1 );
		c2.g = 0;		
		Assert.assertFalse( c1.equals( c2 ) );

		c2.set( c1 );
		c2.b = 0;		
		Assert.assertFalse( c1.equals( c2 ) );

		c2.set( c1 );
		c2.a = 0;		
		Assert.assertFalse( c1.equals( c2 ) );
		
		c2.set( c1 );
		Assert.assertTrue( c1.equals( c1 ) );
		Assert.assertFalse( c1.equals( null ) );
		Assert.assertFalse( c1.equals( "not even a colour!" ) );

	}
	
	@Test
	public void testToStringAndSimilars() {
		Color colour;		
		colour = new Color( 0xFF00FF00 );
		Assert.assertEquals( "0 255 0 255", colour.toString() );
		Assert.assertEquals( "#00FF00", colour.getHTMLColor().toUpperCase() );
		Assert.assertEquals( colour, Color.getColorFromHTMLColor( "#00FF00" ) );
		colour.set( 255, 128, 64 );
		Assert.assertEquals( "255 128 64 255", colour.toString() );		
		Assert.assertEquals( "rgb( 255, 128, 64 )", colour.getExplicitRGBColor() );		
		
	}
	
	@Test
	public void testConstructors() {
		
		Color colour;
		
		colour = new Color( 0xFF00FF00 );
		Assert.assertEquals( 255, colour.a );
		Assert.assertEquals( 0, colour.r );
		Assert.assertEquals( 255, colour.g );
		Assert.assertEquals( 0, colour.b );
		
		colour = new Color( 255, 128, 64, 32 );
		Assert.assertEquals( 32, colour.a );
		Assert.assertEquals( 255, colour.r );
		Assert.assertEquals( 128, colour.g );
		Assert.assertEquals( 64, colour.b );
		
		colour = new Color();
		Assert.assertEquals( 255, colour.a );
		Assert.assertEquals( 0, colour.r );
		Assert.assertEquals( 0, colour.g );
		Assert.assertEquals( 0, colour.b );		
		

		colour = new Color( 768, 1025, -1, -255 );
		Assert.assertEquals( 0, colour.a );
		Assert.assertEquals( 255, colour.r );
		Assert.assertEquals( 255, colour.g );
		Assert.assertEquals( 0, colour.b );


		colour = new Color( 255, 128, 64 );
		Assert.assertEquals( 255, colour.a );
		Assert.assertEquals( 255, colour.r );
		Assert.assertEquals( 128, colour.g );
		Assert.assertEquals( 64, colour.b );	
		
		colour = new Color( new Color( 64, 128, 255 ) );
		Assert.assertEquals( 255, colour.a );
		Assert.assertEquals( 64, colour.r );
		Assert.assertEquals( 128, colour.g );
		Assert.assertEquals( 255, colour.b );		


		colour = new Color( 1.0f, 0.5f, 0.25f );
		Assert.assertEquals( 255, colour.a );
		Assert.assertEquals( 255, colour.r );
		Assert.assertEquals( 128, colour.g );
		Assert.assertEquals( 64, colour.b );		

		colour = new Color( 1.0f, 0.5f, 0.25f, 0.125f );
		Assert.assertEquals( 32, colour.a );
		Assert.assertEquals( 255, colour.r );
		Assert.assertEquals( 128, colour.g );
		Assert.assertEquals( 64, colour.b );
	}
}
