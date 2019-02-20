package event.domain;

import java.util.List;
import java.util.ArrayList;

public class Event {
	private String title;
	private String venue;
	private String theme;
	private String date;
	private List<Talk> talks;
	private List<Guest> guests;
	
	public void addTalk(double duration,String title,String speaker) {
		Talk aTalk = new Talk(duration,title,speaker);
		talks.add(aTalk);
	}
	
	public void addGuest(String name,String contact) {
		Guest aGuest = new Guest(name,contact);
		guests.add(aGuest);
	}
	
	public String getTitle() {		
		return title;
	}
	
	public String getVenue() {		
		return venue;
	}
	
	public String getTheme() {		
		return theme;
	}
	
	public String getDate() {		
		return date;
	}
	
	public List<Talk> getTalks(){
		return talks;
	}
	
	public List<Guest> getGuests(){
		return guests;
	}
	
	public Event(String title,String venue,
			String theme,String date) {
		this.title = title;
		this.venue = venue;
		this.theme = theme;
		this.date = date;
		talks = new ArrayList<Talk>();
		guests = new ArrayList<Guest>();
	}
}
