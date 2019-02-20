package event.domain;

import java.util.List;

public interface IEventRegistry {
	public void addEvent(String title,String venue,
			String theme,String date);
	public int getNumberOfEvents();
	public List<Event> getEvents();
}
