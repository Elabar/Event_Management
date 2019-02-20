package event.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import event.domain.*;

public class EventApp {

	private static Scanner scanner;
	
	private static IEventRegistry eventList;
	
	public static void main(String[] args) {
		eventList = new EventRegistryList();
		
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
	    		//case 3: System.exit(0);
	    	}
	
	    	System.out.println();
		} while (choice != 4);
	}
	
	public static void subMenu(int selectedEvent) {
		int choice;
		System.out.println(selectedEvent);
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


}
