 package model;

import structures.HashTable;

public class Shelf {
	private String identifier;
	private int allGames;
	private HashTable<Integer, Game> shelf;
	private Game game;
	
	public Shelf(String id, int g) {
		identifier = id;
		allGames = g;
		shelf = new HashTable<>(allGames);
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getGames() {
		return allGames;
	}

	public void setGames(int games) {
		this.allGames = games;
	}
	
	public void addGames(double p, int id, int q) {
		game = new Game(p, id, q);
		shelf.insert(game.getIndentifier(), game);
	}
	
	public boolean content(int id) {
		return shelf.contains(id);
	}
	
}
