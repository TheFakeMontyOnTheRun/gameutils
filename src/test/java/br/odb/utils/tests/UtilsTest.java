package br.odb.utils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.Utils;


public class UtilsTest {
	
	@Test
	public void testClampInt() {
		Assert.assertEquals( 255, Utils.clamp( Integer.MAX_VALUE, 0, 255 ) );
		Assert.assertEquals( 0, Utils.clamp( Integer.MIN_VALUE, 0, 255 ) );
		Assert.assertEquals( 137, Utils.clamp( 137, 0, 255 ) );
		Assert.assertEquals( 255, Utils.clamp( 256, 0, 255 ) );
		Assert.assertEquals( 0, Utils.clamp( -1, 0, 255 ) );
		
		Assert.assertEquals( 255, Utils.clamp( Integer.MAX_VALUE, 255, 0 ) );
		Assert.assertEquals( 0, Utils.clamp( Integer.MIN_VALUE, 255, 0 ) );
		Assert.assertEquals( 137, Utils.clamp( 137, 255, 0 ) );
		Assert.assertEquals( 255, Utils.clamp( 256, 255, 0 ) );
		Assert.assertEquals( 0, Utils.clamp( -1, 255, 0 ) );

		
		Assert.assertEquals( Integer.MAX_VALUE, Utils.clamp( Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE ) );
		Assert.assertEquals( Integer.MAX_VALUE, Utils.clamp( 137, Integer.MAX_VALUE, Integer.MAX_VALUE ) );
		Assert.assertEquals( Integer.MAX_VALUE, Utils.clamp( 256, Integer.MAX_VALUE, Integer.MAX_VALUE ) );
		Assert.assertEquals( Integer.MAX_VALUE, Utils.clamp( -1, Integer.MAX_VALUE, Integer.MAX_VALUE ) );		
	}
	
	
	@Test
	public void testClampFloat() {
		Assert.assertEquals( 255, Utils.clamp( Float.MAX_VALUE, 0, 255 ), 0.001f );
		Assert.assertEquals( 0, Utils.clamp( Float.MIN_VALUE, 0, 255 ), 0.001f );
		Assert.assertEquals( 137, Utils.clamp( 137, 0, 255 ), 0.001f );
		Assert.assertEquals( 255, Utils.clamp( 256, 0, 255 ), 0.001f );
		Assert.assertEquals( 0, Utils.clamp( -1, 0, 255 ), 0.001f );
		
		Assert.assertEquals( 255, Utils.clamp( Float.MAX_VALUE, 255, 0 ), 0.001f );
		Assert.assertEquals( 0, Utils.clamp( Float.MIN_VALUE, 255, 0 ), 0.001f );
		Assert.assertEquals( 137, Utils.clamp( 137, 255, 0 ), 0.001f );
		Assert.assertEquals( 255, Utils.clamp( 256, 255, 0 ), 0.001f );
		Assert.assertEquals( 0, Utils.clamp( -1, 255, 0 ), 0.001f );

		
		Assert.assertEquals( Float.MAX_VALUE, Utils.clamp( Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE ), 0.001f );
		Assert.assertEquals( Float.MAX_VALUE, Utils.clamp( 137, Float.MAX_VALUE, Float.MAX_VALUE ), 0.001f );
		Assert.assertEquals( Float.MAX_VALUE, Utils.clamp( 256, Float.MAX_VALUE, Float.MAX_VALUE ), 0.001f );
		Assert.assertEquals( Float.MAX_VALUE, Utils.clamp( -1, Float.MAX_VALUE, Float.MAX_VALUE ), 0.001f );		
	}
	
	@Test
	public void testClass() {
		new Utils();
	}
	
	
	@Test
	public void testEqFloat() {
		
		Assert.assertTrue( Utils.eqFloat( 1.49f, 1.51f ) );
		
		Assert.assertFalse( Utils.eqFloat( 1.0f, 1.1f ) );
		Assert.assertFalse( Utils.eqFloat( 1.0f, 1.49999f ) );
		Assert.assertFalse( Utils.eqFloat( 1.0f, 1.5111f ) );
		Assert.assertFalse( Utils.eqFloat( 1.0f, 2.0f ) );
		
		Assert.assertFalse( Utils.eqFloat( 1.1f, 1.0f ) );
		Assert.assertTrue( Utils.eqFloat( 1.09999f, 1.0f ) );
		Assert.assertFalse( Utils.eqFloat( 1.5111f, 1.0f ) );
		Assert.assertFalse( Utils.eqFloat( 2.0f, 1.0f ) );

	}
}
