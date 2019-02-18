package event.domain;

import java.util.ArrayList;

public interface IEventRegistry {
	public void addEvent(String title,String venue,
			String theme,String date);
	public int getNumberOfEvents();
	public ArrayList<Event> getEvents();
}
