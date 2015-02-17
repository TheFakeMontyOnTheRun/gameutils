package br.odb.utils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.Color;

public class ColorTest {

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
