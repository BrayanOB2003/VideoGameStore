package model;

import java.util.ArrayList;

public class Store {
	private int cachier;
	private Shelf[] shelves;
	private Client[] clients;
 	
	public Store(int shelvesSize, int clientsSize, int c) {
		shelves = new Shelf[shelvesSize];
		clients = new Client[clientsSize];
		cachier = c;
	}
	
	public boolean createShelf(String id, int g) {
		Shelf newShelf = new Shelf(id, g);
		boolean added = false;
		for(int i = 0; i < shelves.length && !added; i++) {
			if(shelves[i] == null) {
				shelves[i] = newShelf;
				added = true;
			}
		}
		return added;
	}
	
	public boolean addGamesToShelf(String id, double p, int idGame, int q) {
		
		boolean added = false; 
		for(int i = 0; i < shelves.length; i++) {
			if(shelves[i].getIdentifier().equals(id)) {
				added = shelves[i].addGames(p, idGame, q);
			}
		}
		
		return added;
	}
	
	public boolean verifyList(Integer[] codes) {
		
		boolean found = true;
		
		for (int i = 0; i < codes.length && found; i++) {
			for (int j = 0; j < shelves.length; j++) {
				if(!shelves[j].content(codes[i])) {
					found = false;
				}
			}
		}
		
		return found;
		
	}
	
	public Game getGame(String id, int ide) {
		Game g = null;
		for(int i = 0; i < shelves.length; i ++) {
			if(shelves[i].getIdentifier().equals(id)) {
				g = shelves[i].getGame(ide);
			}
		}
		
		return g;
	}
	
	public boolean addClient(String id,Integer[] g) {
		Client newClient = new Client(id, g);
		boolean added = false;
		for(int i = 0; i < clients.length && !added; i++) {
			if(clients[i] == null) {
				newClient = searchGames(newClient);
				clients[i] = newClient;
				added = true;
			}
		}
		
		
		return added;
	}
	
	private Client searchGames(Client c) {
		Client client = c;
		Integer[] games = client.getGames();
		
		client.setGames(sort(games));
		return client;
	}
	
	private Integer[] sort(Integer[] a) {
		Integer[] games = a;
		ArrayList<Integer> arraySort = new ArrayList<>();
	    for(int i = 0; i < shelves.length; i++) {
	       for(int j = 0;j < games.length;j++) {
	         if (shelves[i].content(games[j])) {
	        	 arraySort.add(games[j]);
	         }
	       }
	    }
	    
	    for(int i = 0; i < games.length; i++) {
	    	games[i] = arraySort.get(i);
	    }
	    
	    return games;
	    
	}

	public Shelf[] getShelves() {
		return shelves;
	}

	public void setShelves(Shelf[] shelves) {
		this.shelves = shelves;
	}

	public Client[] getClients() {
		return clients;
	}

	public void setClients(Client[] clients) {
		this.clients = clients;
	}
}

