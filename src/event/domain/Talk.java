package event.domain;

public class Talk {
	private String title;
	private String speaker;
	
	public Talk(String title,String speaker) {
		this.title = title;
		this.speaker = speaker;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}
}
