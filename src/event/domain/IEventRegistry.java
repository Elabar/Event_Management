package event.domain;

import java.util.List;

public interface IEventRegistry {
	public void addEvent(String title,String venue,
			String theme,String date);
	public int getNumberOfEvents();
	public List<Event> getEvents();
	public void addTalk(int selectedEvent,double duration,String title,String speaker);
	public List<Talk> getTalks(int selectedEvent);
	public void addGuest(int selectedEvent,String name,String contact);
	public List<Guest> getGuests(int selectedEvent);
}
