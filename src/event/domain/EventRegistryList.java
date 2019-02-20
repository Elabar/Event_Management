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
	
	public void addTalk(int selectedEvent,double duration,String title,String speaker) {
		events.get(selectedEvent - 1).addTalk(duration, title, speaker);
	}
	
	public int getNumberOfEvents() {
		return events.size();
	}
	
	public List<Event> getEvents(){
		return events;
	}
	
	public List<Talk> getTalks(int selectedEvent){
		return events.get(selectedEvent - 1).getTalks();
	}
}
