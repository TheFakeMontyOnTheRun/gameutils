package br.odb.gameutils;

import java.util.ArrayList;

public class EventManager {
	public ArrayList<ScheduledEvent> events = new ArrayList<ScheduledEvent>();

	public void update(long milisseconds) {

		for (ScheduledEvent ev : events) {

			if (ev.wentOff) {
				continue;
			}

			ev.timeToGoOff -= milisseconds;

			if (ev.timeToGoOff <= 0) {
				ev.run();
				ev.wentOff = true;
			}
		}
	}
}
