package model;

import structures.Stack;

public class Client {
	private String id;
	private Integer[] games;
	private Stack<Game> physicGames;
	private Stack<Game> paidGames;
	private int time;
	
	public Client(String id,Integer[] g) {
		physicGames = new Stack<Game>();
		paidGames = new Stack<>();
		games = g;
		this.id = id;
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

	public Stack<Game> getPhysicGames() {
		return physicGames;
	}

	public void setPhysicGames(Stack<Game> physicGames) {
		this.physicGames = physicGames;
	}
	
	public void addPhysicGame(Game game) {
		physicGames.add(game);
	}
	
	public double getPriceAllGame() {
		double price = 0;
		for(int i = 0; i < physicGames.getSize(); i++) {
			price += physicGames.peek().getPrice();
			physicGames.pop();
		}
		
		return price;
	}

	public Stack<Game> getPaidGames() {
		return paidGames;
	}

	public void setPaidGames(Stack<Game> paidGames) {
		this.paidGames = paidGames;
	}
	
	public String outputsClient() {
		String output = "";
		
<<<<<<< HEAD
=======
		
>>>>>>> branch 'master' of https://github.com/BrayanOB2003/VideoGameStore.git
		output = "********************"+ "\n" +
		"Cliente: " + id + "\n" +
		"Orden de recogida: " + getGames2() + "\n" +
<<<<<<< HEAD
		"Orden de facturación " + toString()  + "\n" +
=======
		"Orden de facturación " + physicGames.toString()  + "\n" +
>>>>>>> branch 'master' of https://github.com/BrayanOB2003/VideoGameStore.git
		"Precio total de compra " + getPriceAllGame() + "\n" +
		"****************************";
		
		return output;
	}

	public int getTime() {
		return time;
	}
	
	public String getGames2() {
		String output = "";
		
		for (int i = 0; i < games.length; i++) {
			output+= games[i] + " ";
			
		}
		return output;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getAllGames() {
		return games.length;
	}
	
	public String toString() {
		String out = "";
		for(int i = 0; i < physicGames.getSize(); i++) {
			out += " " + physicGames.pop();
		}
		return out;
	}
}
