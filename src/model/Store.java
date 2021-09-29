package model;

public class Store {
	private int cachier;
	private Shelf[] shelves;
	private Client[] clients;
 	
	public Store(int shelvesSize, int clientsSize, int c) {
		shelves = new Shelf[shelvesSize];
		clients = new Client[clientsSize];
		cachier = c;
	}
	
	public Shelf addShelf(String id, int g) {
		Shelf newShelf = new Shelf(id, g);
		boolean added = false;
		for(int i = 0; i < shelves.length && !added; i++) {
			if(shelves[i] == null) {
				shelves[i] = newShelf;
				added = true;
				return newShelf;
			} else {
				added = false;
			}
		}
		
		//return added;
		return null;
	}
	
	public boolean addClient(String id,Integer[] g, boolean typeOfSort) {
		Client newClient = new Client(id, g);
		newClient = searchGames(newClient,typeOfSort);
		boolean added = false;
		for(int i = 0; i < clients.length; i++) {
			if(clients[i] == null) {
				clients[i] = newClient;
				added = true;
			}
		}
		
		
		return added;
	}
	
	private Client searchGames(Client c, boolean s) {
		Client client = c;
		Integer[] games = client.getGames();
		
		if(s) {
			client.setGames(bubbleSort(client.getGames()));
		} else {
			client.setGames(selectionSort(client.getGames()));
		}
		
		client.setGames(games);
		return client;
	}
	
	private Integer[] bubbleSort(Integer[] a) {
	 
		int auxiliar;
		Integer[] games = a;
		Integer[] arraySort;
	    for(int i = 0; i < games.length; i++) {
	       for(int j = 0;j < games.length-i;j++) {
	         if(!shelves[i].content(games[j]) && shelves[i].content(games[j+1])) {
	           auxiliar = games[j];
	           games[j] = games[j+1];
	           games[j+1] = auxiliar;
	         }
	       }
	    }
	    arraySort = games;

	    return arraySort;
	    
	}
	
	private Integer[] selectionSort(Integer[] a) {
		
		int aux = 0;
		Integer[] games = a;
		Integer[] arraySort;
		
		for(int i = 0; i < games.length; i++) {
			for(int j = 0; j < games.length-i; j++) {
				
				if(shelves[i].content(games[j])) {
					aux = games[i];
					games[i] = games[j];
					games[j] = aux;
				}
			}
		}
		
		arraySort = games;
		
		return arraySort;
	}
	
}

