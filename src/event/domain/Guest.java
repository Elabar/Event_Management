package event.domain;

public class Guest {
	private String name;
	private String contact;
	private boolean status; //true = accepted, false = rejected, null = unknown
	
	//temporary set function
	public void setStatus(boolean reply) {
		status = reply;
	}
	
	public Guest (String name,String contact) {
		this.name = name;
		this.contact = contact;
	}
}
