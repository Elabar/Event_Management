package event.domain;

public class Controller {
	private IEventList eventList;
	
	public void updateGuestStatus(Guest aGuest,String status) {
		aGuest.setReplyStatus(status);
	}
	
	public Guest selectGuest(int index,Event anEvent) {
		return anEvent.getAllGuest().get(index);
	}
	
	public Event selectEvent(int index) {
		return eventList.getAllEvent().get(index);
	}
	
}
