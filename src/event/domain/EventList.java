package event.domain;


import java.util.ArrayList;
import java.util.List;

public class EventList implements IEventList{
	private List<Event> events;
	
	public EventList() {
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
	
	public void addGuest(int selectedEvent,String name,String contact) {
		events.get(selectedEvent - 1).addGuest(name, contact);
	}
	
	public void updateStatus(int selectedEvent,int selectedGuest,String reply) {
		events.get(selectedEvent - 1).updateStatus(selectedGuest - 1, reply);
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
	
	public List<Guest> getGuests(int selectedEvent) {
		return events.get(selectedEvent - 1).getGuests();
	}
}
