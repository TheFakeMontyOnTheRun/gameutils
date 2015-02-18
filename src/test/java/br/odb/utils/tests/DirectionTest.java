/**
 * 
 */
package br.odb.utils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.utils.Direction;

/**
 * @author monty
 *
 */
public class DirectionTest {

	/**
	 * Test method for {@link br.odb.utils.Direction#toString()}.
	 */
	@Test
	public void testToString() {
		for ( Direction d : Direction.values() ) {
			Assert.assertEquals( d.prettyName, d.toString() );
		}
	}

	/**
	 * Test method for {@link br.odb.utils.Direction#getDirectionForPrettyName(java.lang.String)}.
	 */
	@Test
	public void testGetDirectionForPrettyName() {
		
		for ( Direction d : Direction.values() ) {
			Assert.assertEquals( d, Direction.getDirectionForPrettyName( d.prettyName ) );
			Assert.assertEquals( d, Direction.getDirectionForPrettyName( d.prettyName.toLowerCase() ) );
			Assert.assertEquals( d, Direction.getDirectionForPrettyName( d.prettyName.toUpperCase() ) );
		}		
		Assert.assertNull( Direction.getDirectionForPrettyName( null ) );
		Assert.assertNull( Direction.getDirectionForPrettyName( "not a direction" ) );
		Assert.assertNull( Direction.getDirectionForPrettyName( "" ) );
	}

	/**
	 * Test method for {@link br.odb.utils.Direction#getDirectionForSimpleName(java.lang.String)}.
	 */
	@Test
	public void testGetDirectionForSimpleName() {
		for ( Direction d : Direction.values() ) {
			Assert.assertEquals( d, Direction.getDirectionForSimpleName( d.simpleName ) );
			Assert.assertEquals( d, Direction.getDirectionForSimpleName( d.simpleName.toLowerCase() ) );
			Assert.assertEquals( d, Direction.getDirectionForSimpleName( d.simpleName.toUpperCase() ) );
		}
		Assert.assertNull( Direction.getDirectionForSimpleName( null ) );
		Assert.assertNull( Direction.getDirectionForSimpleName( "not a direction" ) );
		Assert.assertNull( Direction.getDirectionForSimpleName( "" ) );
	}

	/**
	 * Test method for {@link br.odb.utils.Direction#getOppositeDirection(br.odb.utils.Direction)}.
	 */
	@Test
	public void testGetOppositeDirection() {
		Assert.assertNull( Direction.getOppositeDirection( null ) );
		Assert.assertEquals( Direction.S, Direction.getOppositeDirection( Direction.N ) );
		Assert.assertEquals( Direction.W, Direction.getOppositeDirection( Direction.E ) );
		Assert.assertEquals( Direction.N, Direction.getOppositeDirection( Direction.S ) );
		Assert.assertEquals( Direction.E, Direction.getOppositeDirection( Direction.W ) );
		Assert.assertEquals( Direction.CEILING, Direction.getOppositeDirection( Direction.FLOOR ) );
		Assert.assertEquals( Direction.FLOOR, Direction.getOppositeDirection( Direction.CEILING ) );
	}

}
