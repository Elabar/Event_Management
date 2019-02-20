package event.domain;

public class Guest {
	private String name;
	private String contact;
	private String status; 
	
	public String getName() {
		return name;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getStatus() {
		return status;
	}
	
	//temporary set function
	public void setStatus(String reply) {
		status = reply;
	}
	
	public Guest (String name,String contact) {
		this.name = name;
		this.contact = contact;
		this.status = "Invited";
	}
}
