package Browser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import hack.Hacker;


public class BrowserHistory {
	private ArrayList<String> historyArrayList = new ArrayList<>();
	private LinkedList<String> historyLinkedList = new LinkedList<>();
	private Vector<String> historyVector = new Vector<>();
	private Stack<String> historyStack = new Stack<>();
	
	private HashSet<String> historyHashSet = new HashSet<>();
	private LinkedHashSet<String> historyLinkedHashSet = new LinkedHashSet<>();
	private TreeSet<String> historyTreeSet = new TreeSet<>();
	
	public BrowserHistory(String homepage) {
		super();
		visit(homepage);
	}
	
   	public void visit(String url) {
   		historyArrayList.add(url);
   		historyLinkedList.add(url);
   		historyVector.add(url);
   		historyStack.add(url);
   		
   		historyHashSet.add(url);
   		historyLinkedHashSet.add(url);
   		historyTreeSet.add(url);
   		System.out.println("Navigated to " + url);
	}
   	
   	public void sort() {
   		Collections.sort(historyArrayList);
   		Collections.sort(historyLinkedList);
   		Collections.sort(historyVector);
   		Collections.sort(historyStack);
   		
   		//Sets do not have an order 
   		//Treesets implement SortedSet interface and keeps all its data sorted in ascending order
   		TreeSet<String> SortedSet = new TreeSet<>(historyHashSet);
   		
   		System.out.println("History sorted");
   	}
   	
   	public void deleteHistory() {
   		System.out.println("Enter the Record to be deleted: ");
		String record = MainMenu.scanner.next();
		try {
			deleteHistory(Integer.parseInt(record));
		}
		catch(Exception e) {
			deleteHistory(record);
		}
   	}
   	
   	public void deleteHistory(int index) {	//Deletion Using Index
   		historyArrayList.remove(index);
   		historyLinkedList.remove(index);
   		historyVector.remove(index);
   		historyStack.remove(index);
   		
   		//sets do not maintain any orders 
   		//hence you cannot delete elements in sets using index as parameter
   		System.out.println("Delete History");
   	}
   	
   	public void deleteHistory(String url) {
   		historyArrayList.remove(url);
   		historyLinkedList.remove(url);
   		historyVector.remove(url);
   		historyStack.remove(url);
   		
   		historyHashSet.remove(url);
   		historyLinkedHashSet.remove(url);
   		historyTreeSet.remove(url);
   		
   		System.out.println("Delete History");
   	}
   	
   	public void fetchHistory() {
   		displayArrayListHistory();
   		//displayLinkedListHistory();
   		//displayVectorHistory();
   		//displayStackHistory();
   		//displayHashSetHistory();
   		//displayLinkedHashSetHistory();
   		//displayTreeSetHistory();
   	}
   	
   	public ArrayList<String> getHistory() {
   		return historyArrayList;
   	}
   	
   	public void search(String extension) {
   		System.out.println("URLS Visited with the extension ." + extension);
   		for(String url: historyHashSet) {
   			if(url.endsWith(extension)) {
   				System.out.println(url);
   			}
   		}
   	}
   	
   	public void size() {
   		//implemented using method size() in Collection Interface
   		System.out.println("History Size: " + historyArrayList.size());
   	}
	
   	public void updateHistory(int index, String url) {
   		historyArrayList.set(index, url);
   		historyLinkedList.set(index, url);
   		historyVector.set(index, url);
   		historyStack.set(index, url);
   		//cannot be used on sets
   	}
   	
   	public void displayArrayListHistory() {
   		System.out.println("History ArrayList");
   		System.out.println("------------------");
   		for(int i=0; i<historyArrayList.size(); ++i) {
   			System.out.println(historyArrayList.get(i));
   		}
   	}
   	
   	public void displayLinkedListHistory() {
   		System.out.println("History LinkedList");
   		System.out.println("------------------");
   		Iterator<String> it = historyLinkedList.iterator();
   		while(it.hasNext()) {
   			System.out.println(it.next());
   		}
   	}
   	
   	public void displayVectorHistory() {
   		System.out.println("History Vector");
   		System.out.println("------------------");
   		for(int i=0; i<historyVector.size(); ++i) {
   			System.out.println(historyVector.get(i));
   		}
   	}
   	
   	public void displayStackHistory() {
   		System.out.println("History Stack");
   		System.out.println("------------------");
   		for(int i=0; i<historyStack.size(); ++i) {
   			System.out.println(historyStack.get(i));
   		}
   	}
   	
   	public void displayHashSetHistory() {
   		System.out.println("History HashSet");
   		System.out.println("------------------");
   		for(String url: historyHashSet) {
   			System.out.println(url);
   		}
   	}
   	
   	public void displayLinkedHashSetHistory() {
   		System.out.println("History LinkedHashSet");
   		System.out.println("------------------");
   		for (Iterator iterator = historyLinkedHashSet.iterator(); iterator.hasNext();) {
			String url = (String) iterator.next();
			System.out.println(url);
		}
   	}
   	
   	public void displayTreeSetHistory() {
   		System.out.println("History TreeSet");
   		System.out.println("------------------");
   		for(String url: historyTreeSet) {
   			System.out.println(url);
   		}
   	}
   	
   	public void read() throws IOException {
   		Hacker.readHistory(historyArrayList);
   	}
   	
   	public void write() throws IOException {
   		Hacker.writeHistory(historyArrayList);
   	}
   	
   	
}