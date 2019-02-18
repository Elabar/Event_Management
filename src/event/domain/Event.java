package event.domain;

public class Event {
	private String title;
	private String venue;
	private String theme;
	private String date;
	
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
	
	public Event(String title,String venue,
			String theme,String date) {
		this.title = title;
		this.venue = venue;
		this.theme = theme;
		this.date = date;
	}
}
