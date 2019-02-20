package event.domain;


import java.util.ArrayList;
import java.util.List;

public class EventRegistryList implements IEventRegistry{
	private List<Event> events;
	
	public EventRegistryList() {
		events = new ArrayList<Event>();
	}
	public void addEvent(String title,String venue,
			String theme,String date) {
		Event aEvent = new Event(title,venue,theme,date);
		events.add(aEvent);
	}
	
	public int getNumberOfEvents() {
		return events.size();
	}
	
	public List<Event> getEvents(){
		return events;
	}
}
