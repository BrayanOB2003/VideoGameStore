package model;

import java.util.ArrayList;

import structures.Stack;

public class Store {
	private int cachier;
	private Shelf[] shelves;
	private Client[] clients;
 	
	public Store(int shelvesSize, int clientsSize, int c) {
		shelves = new Shelf[shelvesSize];
		clients = new Client[clientsSize];
		setCachier(c);
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
		newClient = searchGames(newClient);
		newClient = searchPhysictGames(newClient);
		//newClient = payGames(newClient);
		
		for(int i = 0; i < clients.length && !added; i++) {
			if(clients[i] == null) {
				newClient.setTime((i+1) + newClient.getGames().length);
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
	
	private Client searchPhysictGames(Client c) {
		Client client = c;
		Integer[] games = client.getGames();
		Game gameAvailable;
		
		for (int j = 0; j < shelves.length; j++) {
			for (int i = 0; i < games.length; i++) {
				if(shelves[j].content(games[i])) {
					gameAvailable = shelves[j].getGame(games[i]);
					gameAvailable.takeGame();
					shelves[j].modify(games[i], gameAvailable);

					client.addPhysicGame(shelves[j].getGame(games[i]));
				}
			}
		}
		
		return client;
	}
	
	private Client payGames(Client c) {
		Client client = c;
		sortClients();
		Stack<Game> games = client.getPhysicGames();
		Stack<Game> paidGame = new Stack<>();
		int aux = 0;
		
		int i = 0;
		int j = 0;
		
		while(i != j) {
			
		}
		
		client.setPaidGames(paidGame);
		
		return client; 
	}
	
	private int searchMinnor(Client[] c, int a) {
		int index = 0;
		int aux = a;
		for (int i = aux; i < cachier; i++) {
			for (int j = aux; j < cachier; j++) {
				if(c[i].getAllGames() < c[j].getAllGames()) {
					index = i;
				}
			} 
		}
		
		return index;
	}
	
	private void sortClients() {
		for(int j = 1; j < clients.length; j++) {
			for(int i = 0; i < clients.length-j; i++) {
				if(clients[i].getAllGames() > clients[i+1].getAllGames()) {
					Client temp = clients[i];
					clients[i] = clients[i+1];
					clients[i+1] = temp;
				}
			}
		}
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

	public int getCachier() {
		return cachier;
	}

	public void setCachier(int cachier) {
		this.cachier = cachier;
	}
}

