package event.domain;


import java.util.ArrayList;

public class EventRegistryList implements IEventRegistry{
	private ArrayList<Event> events;
	
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
	
	public ArrayList<Event> getEvents(){
		return events;
	}
}
