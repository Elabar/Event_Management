package event.app;

import event.domain.*;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
	private Scanner scanner;
	private Controller controller;
	
	public ConsoleUI() {
		scanner = new Scanner(System.in);
		controller = null;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void start() {
		int choice;
		
		do {
			System.out.println("Do you want to:");
	    	System.out.println("1. Register new event");
	    	System.out.println("2. Add guest to event");
	    	System.out.println("3. Add talk to event");
	    	System.out.println("4. Display all event");
	    	System.out.println("5. Display guests in an event");
	    	System.out.println("6. Display talks in an event");
	    	System.out.println("7. Update guest's status");
	    	System.out.println("8. Exit");
	    	
	    	System.out.print("Enter your choice (1-8): ");
	    	choice = scanner.nextInt();
	
	    	while (choice < 1 || choice > 8) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Enter your choice (1-8): ");
	        	choice = scanner.nextInt();
	    	}
	    	
	    	switch(choice) {
	    		case 1: addEvent(); break;
	    		case 2: addGuest(); break;
	    		case 3: addTalk(); break;
	    		case 4: displayAllEvent(); break;
	    		case 5: displayGuests(); break;
	    		case 6: displayTalks(); break;
	    		case 7: updateGuestStatus(); break;
	    		case 8: System.exit(0);
	    	}
	
	    	System.out.println();
		} while (choice != 8);
	}
	
	public void addEvent() {
		System.out.println("Enter event title: ");
		String skip = scanner.nextLine();
		String theTitle = scanner.nextLine();
		
		System.out.println("Enter event theme: ");
		String theme = scanner.nextLine();
		
		System.out.println("Enter event venue: ");
		String venue = scanner.nextLine();
		
		System.out.println("Enter event duration: ");
		int duration = scanner.nextInt();
		skip = scanner.nextLine();
		
		controller.addEvent(theTitle, venue, theme, duration);
		System.out.println("Event added");
		System.out.println();
	}
	
	public void addGuest() {
		Event anEvent = selectEvent();
		
		System.out.println("Enter guest's name: ");
		String skip = scanner.nextLine();
		String name = scanner.nextLine();
		
		System.out.println("Enter guest's contact: ");
		String contact = scanner.nextLine();
		
		controller.addGuest(anEvent, name, contact);
	}

	public void addTalk() {
		Event anEvent = selectEvent();
		
		System.out.println("Enter talk's title: ");
		String skip = scanner.nextLine();
		String title = scanner.nextLine();
		
		System.out.println("Enter guest's contact: ");
		String speaker = scanner.nextLine();
		
		controller.addTalk(anEvent, title, speaker);
	}
	
	public void displayAllEvent() {
		int count = controller.getNumberOfEvent();
		
		if(count > 0) {
			List<Event> events = controller.getAllEvent();
			
			for(int i = 0;i < count;i++) {
				System.out.println(i+1 + ". " + events.get(i).getTitle());
			}
		}
	}
	
	public void displayGuests() {
		Event anEvent = selectEvent();
		String skip = scanner.nextLine();
		
		int count = controller.getNumberOfGuest(anEvent);
		if(count > 0) {
			List<Guest> guests = controller.getAllGuest(anEvent);
			
			for(int i = 0;i < count;i++) {
				System.out.println(i+1 + ". " + guests.get(i).getName() + "\t Contact: " + guests.get(i).getContact());
			}
		}else {
			System.out.println("No guest is in this event.");
		}
		
		System.out.println();
	}

	public void displayTalks() {
		Event anEvent = selectEvent();
		String skip = scanner.nextLine();
		
		int count = controller.getNumberOfTalk(anEvent);
		if(count > 0) {
			List<Talk> talks = controller.getAllTalk(anEvent);
			
			for(int i = 0;i < count;i++) {
				System.out.println(i+1 + ". " + talks.get(i).getTitle() + "\t Speaker: " + talks.get(i).getSpeaker());
			}
		}else {
			System.out.println("No talk is in this event.");
		}
		
		System.out.println();
	}

	public Event selectEvent() {
		int choice;
		
		displayAllEvent();
		System.out.print("Select event according to index: ");
		choice = scanner.nextInt();
		
		while (choice < 1 || choice > controller.getNumberOfEvent()) {
        	System.out.println("Invalid choice.");
        	System.out.print("Enter your choice (1-" + controller.getNumberOfEvent() +"): ");
        	choice = scanner.nextInt();
    	}
		
		return controller.selectEvent(choice-1);
	}
	
	public Guest selectGuest() {
		int choice;
		
		Event anEvent = selectEvent();
		displayGuests();
		System.out.print("Select guest according to index: ");
		choice = scanner.nextInt();
		
		while (choice < 1 || choice > controller.getNumberOfGuest(anEvent)) {
        	System.out.println("Invalid choice.");
        	System.out.print("Enter your choice (1-" + controller.getNumberOfGuest(anEvent) +"): ");
        	choice = scanner.nextInt();
    	}
		
		return controller.selectGuest(choice, anEvent);
	}
	
	public void updateGuestStatus() {
		Guest aGuest = selectGuest();
		
		System.out.println("Please enter the latest status(accepted/rejected): ");
		String skip = scanner.nextLine();
		String status = scanner.nextLine();
		
		while (status.equalsIgnoreCase("accepted") || status.equalsIgnoreCase("rejected")) {
        	System.out.println("Invalid status.");
        	System.out.print("Please enter the latest status(accepted/rejected): ");
        	status = scanner.nextLine();
    	}
		
		controller.updateGuestStatus(aGuest,status);
		
		System.out.println("Status updated.");
		System.out.println();
	}
}
