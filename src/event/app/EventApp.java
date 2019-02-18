package event.app;

import java.util.Scanner;
import java.util.ArrayList;

import event.domain.*;

public class EventApp {

	private static Scanner scanner;
	
	private static IEventRegistry eventList;
	
	public static void main(String[] args) {
		eventList = new EventRegistryList();
		
		scanner = new Scanner(System.in);
		
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
	    	}
	
	    	System.out.println();
		} while (choice != 4);
	}
	
	public static void addEvent() {
		System.out.print("Enter event title: ");
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
		 ArrayList<Event> theEvents = eventList.getEvents();
		 Event aEvent;
		 System.out.println("Events");
		 for (int i=0; i< theEvents.size(); i++) {
			 aEvent = theEvents.get(i);
			 System.out.println(i+1 + ". Title: " + aEvent.getTitle() 
				+ "\tVenue: " + aEvent.getVenue()
			  	+ "\tTheme: " + aEvent.getTheme()
			  	+ "\tDate: " + aEvent.getDate());
		 }
	}


}
