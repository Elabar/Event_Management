package event.domain;

public class Talk {
	private double duration; //minute as unit
	private String title;
	private String speaker;
	
	public double getDuration() {
		return duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}
	public Talk(double duration,String title,String speaker) {
		this.duration = duration;
		this.title = title;
		this.speaker = speaker;
	}
}
