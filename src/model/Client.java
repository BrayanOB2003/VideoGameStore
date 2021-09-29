package model;

import structures.Stack;

public class Client {
	private String id;
	private Integer[] games;
	private Stack<Integer> physicGames;
	
	public Client(String id,Integer[] g) {
		games = g;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer[] getGames() {
		return games;
	}

	public void setGames(Integer[] games) {
		this.games = games;
	}

	public Stack<Integer> getPhysicGames() {
		return physicGames;
	}

	public void setPhysicGames(Stack<Integer> physicGames) {
		this.physicGames = physicGames;
	}
	
	public void addPhysicGame(int game) {
		physicGames.add(game);
	}
}
