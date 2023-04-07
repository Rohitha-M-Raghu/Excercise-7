package Browser;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class MainMenu {
	public static Scanner scanner = new Scanner(System.in);
	private static BrowserHistory browserHistory = new BrowserHistory("www.google.com");

	public static void main(String[] args) throws IOException {
		boolean quit = false;
		while(!quit) {
			System.out.println("Browser");
			System.out.println("===================");
			System.out.println("1. Visit url");
			System.out.println("2. Sort History");
			System.out.println("3. Delete History");
			System.out.println("4. Fetch History");
			System.out.println("5. Search Extension");
			System.out.println("6. Size");
			System.out.println("7. Update History");
			System.out.println("8. Display History");
			System.out.println("9. Read");
			System.out.println("10. Write");
			System.out.println("11. Quit");
			System.out.print("Enter your Choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: 
					System.out.print("Enter url: ");
			        String url = scanner.next();
			        browserHistory.visit(url);
				break;
			case 2: 
					browserHistory.sort();
				break;
			case 3: 
					browserHistory.deleteHistory();
				break;
			case 4: 
					browserHistory.fetchHistory();
				break;
			case 5: 
					System.out.println("Enter extension: ");
					String extension = scanner.next();
					browserHistory.search(extension);
				break;
			case 6: 
					browserHistory.size();
				break;
			case 7: 
					System.out.println("Enter Index: ");
					int index = scanner.nextInt();
					System.out.println("Enter url to update: ");
					String updateUrl = scanner.next();
					browserHistory.updateHistory(index, updateUrl);
				break;
			case 8: display();
					break;
			case 9:
					browserHistory.read();
					break;
			case 10:
					browserHistory.write();
					break;
			case 11: System.out.println("Exiting Application....");
					quit = true;
				break;
			default:
				break;
			}
		}
	}
	
	public static void display() {
		System.out.println("HISTORY");
		System.out.println("------------------");
		for(String url: browserHistory.getHistory()) {
			System.out.println(url);
		}
	}
	
}
