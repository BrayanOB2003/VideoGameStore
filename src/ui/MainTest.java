package ui;

import model.*;

public class MainTest {
	public static void main(String[] args) {
		boolean a = false;
		
		Store store = new Store(3, 2, 3);
		store.createShelf("A", 2);
		store.createShelf("B", 4);
		store.createShelf("C", 4);
		
		store.addGamesToShelf("A", 3500,4, 23);
		store.addGamesToShelf("A", 2500,3, 23);
		store.addGamesToShelf("A", 1500,2, 23);
		store.addGamesToShelf("B", 500, 1, 23);
		store.addGamesToShelf("B", 500, 5, 23);
		store.addGamesToShelf("C", 500, 6, 23);
		store.addGamesToShelf("B", 500, 7, 23);
		Integer[] games = {1,2,3,4,5,6,7};
		store.addClient("1234", games);
		Integer[] g = store.getClients()[0].getGames();
		
		String c = ""; 
		
		System.out.println(c);
	}
}
