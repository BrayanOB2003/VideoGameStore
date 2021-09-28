package model;

import structures.Queue;

public class Client {
	private String id;
	private Integer[] games;
	private Queue<Integer> physicGames;
	
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

	public Queue<Integer> getPhysicGames() {
		return physicGames;
	}

	public void setPhysicGames(Queue<Integer> physicGames) {
		this.physicGames = physicGames;
	}
	
	public void addPhysicGame(int game) {
		physicGames.add(game);
	}
}
