package event.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import event.domain.*;

public class EventApp {

	private static Scanner scanner;
	
	private static IEventList eventList;
	
	public static void main(String[] args) {
		eventList = new EventList();
		
		scanner = new Scanner(System.in);
		
		mainMenu();
		
	}
	
	public static void mainMenu() {
		int choice;
		
		do {
			System.out.println("Do you want to:");
	    	System.out.println("1. Register new event");
	    	System.out.println("2. Display all events");
	    	System.out.println("3. Exit");
	    	
	    	System.out.print("Enter your choice (1-3): ");
	    	choice = scanner.nextInt();
	
	    	while (choice < 1 || choice > 3) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Enter your choice (1-3): ");
	        	choice = scanner.nextInt();
	    	}
	    	
	    	switch(choice) {
	    		case 1: addEvent(); break;
	    		case 2: displayEvents(); break; 
	    		case 3: System.exit(0);
	    	}
	
	    	System.out.println();
		} while (choice != 4);
	}
	
	public static void subMenu(int selectedEvent) {
		int choice;
		System.out.println(selectedEvent);//debug purpose
		do {
			System.out.println("Do you want to:");
	    	System.out.println("1. Append new talk");
	    	System.out.println("2. Invite new guest");
	    	System.out.println("3. Update guest status");
	    	System.out.println("4. Display all talks");
	    	System.out.println("5. Display all guests");
	    	System.out.println("6. Back to main menu");
	    	
	    	System.out.print("Enter your choice (1-6): ");
	    	choice = scanner.nextInt();
	    	
	    	while (choice < 1 || choice > 6) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Enter your choice (1-6): ");
	        	choice = scanner.nextInt();
	    	}
	    	
	    	switch(choice) {
	    		//to be added
	    		case 1: addTalk(selectedEvent); break;
	    		case 2: addGuest(selectedEvent); break;
	    		case 4: displayTalk(selectedEvent); break;
	    		case 5: displayGuest(selectedEvent); break;
	    		case 6: mainMenu(); break;                  
	    	}
		}while(choice != 6);
	}
	
	public static void selectEvent() {
		int choice;

		System.out.print("Select event according to index or 0 to go back to main menu: ");
		choice = scanner.nextInt();
		
		while (choice < 0 || choice > eventList.getNumberOfEvents()) {
        	System.out.println("Invalid choice.");
        	System.out.print("Enter your choice (0-" + eventList.getNumberOfEvents() +"): ");
        	choice = scanner.nextInt();
    	}
		
		if(choice == 0 ) {
			mainMenu();
		}else {
			subMenu(choice);
		}
	}
	
	public static void addEvent() {
		System.out.println("Enter event title: ");
		// clear previous input before input name
		String skip = scanner.nextLine();
		String theTitle = scanner.nextLine();
		System.out.println("Enter event venue: ");
		String theVenue = scanner.nextLine();
		System.out.println("Enter event theme: ");
		String theTheme = scanner.nextLine();
		System.out.println("Enter event date: ");
		String theDate = scanner.nextLine();
		    	
		eventList.addEvent(theTitle, theVenue, theTheme, theDate);
		System.out.println("Event added");
		System.out.println();
	}
	
	public static void displayEvents() {
		 List<Event> theEvents = eventList.getEvents();
		 Event aEvent;
		 System.out.println("Events");
		 for (int i=0; i< theEvents.size(); i++) {
			 aEvent = theEvents.get(i);
			 System.out.println(i+1 + ". Title: " + aEvent.getTitle() 
				+ "\tVenue: " + aEvent.getVenue()
			  	+ "\tTheme: " + aEvent.getTheme()
			  	+ "\tDate: " + aEvent.getDate());
		 }
		 selectEvent();
	}
	
	public static void addTalk(int selectedEvent) {
		System.out.println("Enter talk's title: ");
		String skip = scanner.nextLine();//clear previous input
		String title = scanner.nextLine();
		System.out.println("Enter talk's speaker: ");
		String speaker = scanner.nextLine();
		System.out.println("Enter talk's duration: ");
		double duration = scanner.nextDouble();
		eventList.addTalk(selectedEvent, duration, title, speaker);
	}
	
	public static void displayTalk(int selectedEvent) {
		List<Talk> theTalks = eventList.getTalks(selectedEvent);
		Talk aTalk;
		System.out.println("Talks");
		for (int i=0; i< theTalks.size(); i++) {
			aTalk = theTalks.get(i);
			System.out.println(i+1 + ". Title: " + aTalk.getTitle() 
				+ "\tSpeaker: " + aTalk.getSpeaker()
				+ "\tDuration: " + aTalk.getDuration());
		}
	}
	
	public static void addGuest(int selectedEvent) {
		System.out.println("Enter guest's name: ");
		String skip = scanner.nextLine();//clear previous input
		String name = scanner.nextLine();
		System.out.println("Enter guest's contact: ");
		String contact = scanner.nextLine();
		eventList.addGuest(selectedEvent, name, contact);
	}
	
	public static void displayGuest(int selectedEvent) {
		List<Guest> theGuests = eventList.getGuests(selectedEvent);
		Guest aGuest;
		System.out.println("Guests");
		for (int i=0; i< theGuests.size(); i++) {
			aGuest = theGuests.get(i);
			System.out.println(i+1 + ". Name: " + aGuest.getName()
			+ "\tContact: " + aGuest.getContact()
			+ "\tStatus: " + aGuest.getStatus());
		}
	}

}
