package br.odb.gameutils.tests;

import org.junit.Assert;
import org.junit.Test;

import br.odb.gameutils.EventManager;
import br.odb.gameutils.ScheduledEvent;

public class EventManagerTest {

	class MyRunnable implements Runnable {

		public boolean yeahItDid;
		
		@Override
		public void run() {
			yeahItDid = true;			
		}		
	}
	
	
	@Test
	public void testUpdate() {

		MyRunnable runnable = new MyRunnable();
		ScheduledEvent event = new ScheduledEvent( null, 1000 );
		ScheduledEvent event2 = new ScheduledEvent( runnable, 1000 );
		EventManager manager = new EventManager();
		manager.events.add( event );
		manager.update( 500 );
		Assert.assertFalse( event.wentOff );
		manager.update( 1000 );
		Assert.assertTrue( event.wentOff );
		manager.update( 1000 );
		Assert.assertTrue( event.wentOff );
		
		manager.events.add( event2 );
		manager.update( 500 );
		Assert.assertFalse( event2.wentOff );
		Assert.assertFalse( runnable.yeahItDid );
		manager.update( 1000 );
		Assert.assertTrue( event2.wentOff );
		Assert.assertTrue( runnable.yeahItDid );
		manager.update( 1000 );
		Assert.assertTrue( event2.wentOff );
		Assert.assertTrue( runnable.yeahItDid );		
	}
}
